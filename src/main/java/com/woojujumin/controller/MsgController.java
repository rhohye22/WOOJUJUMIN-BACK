package com.woojujumin.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woojujumin.dto.FreeBbsDto;
import com.woojujumin.dto.MemberDto;
import com.woojujumin.dto.MsgDto;
import com.woojujumin.dto.mypartyBbsParam;
import com.woojujumin.service.MsgService;



@RestController
public class MsgController {
	
	@Autowired
	MsgService service;
	
	@GetMapping(value = "memberlist")
	public List<MemberDto> memberlist(String id) {
		
		System.out.println("MsgController memberlist() " + new Date());
		
		List<MemberDto> list = service.allmember();
		System.out.println("list" + list);
		return list;
	}
	
	// 메시지 보내기(insert)
	@GetMapping(value = "msgWrite")
	public String msgWrite(MsgDto dto) {
		
		System.out.println("MsgController msgWrite() " + new Date());
		System.out.println(dto.toString());
		boolean b = service.msgWrite(dto);
		if(b == false) {
			return "NO";
		}
		return "YES";
	}
	
	// 받은 메시지 보기
	@GetMapping(value = "/msglist")
	public Map<String, Object> msglist(mypartyBbsParam param) {
		
		System.out.println("MsgController msglist : " + new Date());
		
		
		// 글의 시작과 끝
		int pn = param.getPageNumber(); // 0 1 2 3 4
		int start = 1 + (pn * 10); // 1 11
		int end = (pn + 1) * 10; // 10 20
		System.out.println("pn" +pn);
		
		param.setStart(start);
		param.setEnd(end);
		
		List<FreeBbsDto> list = service.msglist(param);
		
		int len = service.getmsglist(param);
		
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", len);
		
		return map;
	}
	// 보낸 메시지 보기
	@GetMapping(value = "/sendmsglist")
	public Map<String, Object> sendmsglist(mypartyBbsParam param) {
		
		System.out.println("MsgController sendmsglist : " + new Date());
		
		
		// 글의 시작과 끝
		int pn = param.getPageNumber(); // 0 1 2 3 4
		int start = 1 + (pn * 10); // 1 11
		int end = (pn + 1) * 10; // 10 20
		System.out.println("pn" +pn);
		
		param.setStart(start);
		param.setEnd(end);
		
		List<FreeBbsDto> list = service.sendmsglist(param);
		
		int len = service.getsendmsglist(param);
		
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", len);
		
		return map;
	}
	//  메시지 삭제
	@GetMapping(value = "/delMsg")
	public String delMsg(MsgDto dto) {
		
		System.out.println("MsgController delMsg : " + new Date());
		System.out.println(dto.toString());
		boolean b = service.delMsg(dto);
		if(b == false) {
			return "NO";
		}
		return "YES";
		
	}

}
