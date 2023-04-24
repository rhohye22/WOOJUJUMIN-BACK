package com.woojujumin.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.woojujumin.dto.FreeBbsDto;
import com.woojujumin.dto.mypartyBbsParam;
import com.woojujumin.service.PartyRequestService;



public class PartyRequestController {

	@Autowired
	PartyRequestService service;
	
	// 내가 파티 요청한거 보여주는 곳
	@GetMapping(value = "/myRequestList")
	public Map<String, Object> myRequestList(mypartyBbsParam param) {
		
		System.out.println("PartyRequestController myRequestList : " + new Date());
		
		
		// 글의 시작과 끝
		int pn = param.getPageNumber(); // 0 1 2 3 4
		int start = 1 + (pn * 10); // 1 11
		int end = (pn + 1) * 10; // 10 20
		System.out.println("pn" +pn);
		
		param.setStart(start);
		param.setEnd(end);
		
		List<FreeBbsDto> list = service.myRequestList(param);
		
		int len = service.getmyRequestList(param);
		
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", len);
		
		return map;
	}
}
