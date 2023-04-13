package com.woojujumin.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import com.woojujumin.dto.QnaDto;
import com.woojujumin.service.QnaService;

@RestController
public class QnaController {
	@Autowired
	QnaService service;
	
	@GetMapping(value = "qnalist")
	public List<QnaDto> qnalist(String id, int start) {
		System.out.println("QnaController qnalist() " + new Date());
		System.out.println(id + " "+start);
		return service.myqna(id,start);
	}
	
	@GetMapping(value = "cntqna")
	public int cntqna(String id) {
		System.out.println("QnaController cntqna() " + new Date());
		return service.cntqna(id);
	}
	
	@PostMapping(value = "qnawrite")
	public String addQna(QnaDto dto) {
		System.out.println("QnaController addQna() " + new Date());
		
		boolean b = service.addQna(dto);
		if(b == false) {
			return "NO";
		}
		return "YES";
	}
	
}