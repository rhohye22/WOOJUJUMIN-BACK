package com.woojujumin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.woojujumin.dto.FreeBbsDto;
import com.woojujumin.service.FreeBbsService;

@RestController
public class FreeBbsController {

	@Autowired
	FreeBbsService service;
	
	@GetMapping("getAllList")
	public List<FreeBbsDto> getAllList() {
		return service.getAllList();
	}
	
	@GetMapping("getBbs")
	public List<FreeBbsDto> getBbs(int bbsSeq) {
		return service.getBbs(bbsSeq);
	}
	
}
