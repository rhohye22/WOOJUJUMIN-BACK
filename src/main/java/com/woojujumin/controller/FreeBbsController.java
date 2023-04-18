package com.woojujumin.controller;


import java.util.Date;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woojujumin.dto.FreeBbsDto;
import com.woojujumin.dto.mypartyBbsParam;
import com.woojujumin.service.FreeBbsService;



@RestController
public class FreeBbsController {

	@Autowired
	FreeBbsService service;
	
	
	// 4/13 내가 쓴 게시판(자유)
		@GetMapping(value = "/myfreeBbslist")
		public Map<String, Object> myfreeBbslist(mypartyBbsParam param) {
			
			System.out.println("BbsController myfreeBbslist : " + new Date());
			System.out.println("id" +param.getId());
			
			// 글의 시작과 끝
			int pn = param.getPageNumber(); // 0 1 2 3 4
			int start = 1 + (pn * 10); // 1 11
			int end = (pn + 1) * 10; // 10 20
			System.out.println("pn" +pn);
			
			param.setStart(start);
			param.setEnd(end);
			
			List<FreeBbsDto> list = service.myfreeBbslist(param);
			
			int len = service.getmyfreeAllBbs(param);
			
			
			Map<String, Object> map = new HashMap<>();
			map.put("list", list);
			map.put("cnt", len);
			
			return map;
			
		}

		@GetMapping("getAllList")
		public List<FreeBbsDto> getAllList() {
			return service.getAllList();
		}
		
		

		@GetMapping("getBbs")
		public List<FreeBbsDto> getBbs(int bbsSeq) {
			return service.getBbs(bbsSeq);
		}

}

