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
	@GetMapping(value = "getQna")
	public QnaDto getQna(int qnaSeq) {
		System.out.println("QnaController getQna() " + new Date());
		return service.getQna(qnaSeq);
	}
	
	//관리자 페이지 
	//답변이 안달린 질문들	
	@GetMapping(value = "allnewqna")
	public List<QnaDto> allnewqna() {
		System.out.println("QnaController allnewqna() " + new Date());
		return service.allnewqna();
	}
	//타입별 질문들	
	@GetMapping(value = "typeqna")
	public List<QnaDto> typeqna(String qtype) {
		System.out.println("QnaController typeqna() " + new Date());
		System.out.println("qtype : " + qtype);
		return service.typeqna(qtype);
	}
	
	//답변이 완료된 질문들
	@GetMapping(value = "answeredqns")
	public List<QnaDto> answeredqns() {
		System.out.println("QnaController answeredqns() " + new Date());
		
		return service.answeredqns();
	}
	
}