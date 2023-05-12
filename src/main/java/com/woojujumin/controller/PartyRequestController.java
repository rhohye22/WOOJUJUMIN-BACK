package com.woojujumin.controller;



import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woojujumin.dto.ApplyDto;
import com.woojujumin.dto.mypartyBbsParam;
import com.woojujumin.service.PartyRequestService;


@RestController
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
		//System.out.println("pn" +pn);
		
		param.setStart(start);
		param.setEnd(end);
		
		List<mypartyBbsParam> list = service.myRequestList(param);
		
		
		int len = service.getmyRequestList(param);
		
		System.out.println("list" + list);
		
		
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("list", list);
		map.put("cnt", len);
		
		return map;
	}
	// 파티장이 파티 수락
	@GetMapping(value = "/myPartyList")
	public Map<String, Object> myPartyList(mypartyBbsParam param) {
		
		System.out.println("PartyRequestController myPartyList : " + new Date());
		
		
		// 글의 시작과 끝
		int pn = param.getPageNumber(); // 0 1 2 3 4
		int start = 1 + (pn * 10); // 1 11
		int end = (pn + 1) * 10; // 10 20
		//System.out.println("pn" +pn);
		
		param.setStart(start);
		param.setEnd(end);
		
		List<mypartyBbsParam> list = service.myPartyList(param);
		
		
		int len = service.getmyPartyList(param);
		
		System.out.println("list" + list);
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("list", list);
		map.put("cnt", len);
		
		return map;
	}
	// 수락버튼 누르면 check 1증가
	@GetMapping(value = "/updateCheck")
	public void updateCheck(ApplyDto dto) {
		
		System.out.println("PartyRequestController updateCheck : " + new Date());
		
		service.updateCheck(dto);// check 1로 올리기
		service.updateCount(dto);
		service.updatefull(dto); // 인원수 다차면 full 1로 바꾸기
	}
	
	// 내파티 보기
	@GetMapping(value = "/partyListmy")
	public Map<String, Object> partyListmy(mypartyBbsParam param) {
		
		System.out.println("PartyRequestController partyListmy : " + new Date());
		
		
		// 글의 시작과 끝
		int pn = param.getPageNumber(); // 0 1 2 3 4
		int start = 1 + (pn * 10); // 1 11
		int end = (pn + 1) * 10; // 10 20
		//System.out.println("pn" +pn);
		
		param.setStart(start);
		param.setEnd(end);
		System.out.println("search" + param.getSearch());
		
		List<mypartyBbsParam> list = service.partyListmy(param);
		
		
		int len = service.getpartyListmy(param);
		
		System.out.println("list" + list);
		
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("list", list);
		map.put("cnt", len);
		
		return map;
	}
	
}
