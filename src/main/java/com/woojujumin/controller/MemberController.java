package com.woojujumin.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woojujumin.dto.MemberDto;
import com.woojujumin.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	MemberService service;
	
	@GetMapping(value = "allmember")
	public List<MemberDto> allmember() {
		System.out.println("MemberController allmember() " + new Date());
		
		return service.allmember();
	}
	
	// 아이디 체크
	@PostMapping(value = "/idcheck")
	public String idcheck(String id) {
		System.out.println("MemberController idcheck " + new Date());
		
		boolean b = service.idcheck(id);
		if(b == true) {
			return "NO";
		}
		
		return "YES";
	}
	
	// 회원가입
	@PostMapping(value = "/addmember")
	public String addmember(MemberDto dto) {
		System.out.println("MemberController addmember " + new Date());
		
		boolean b = service.addmember(dto);
		if(b == false) {
			return "NO";
		}
		return "YES";
	}
	
	// 로그인
	@PostMapping(value = "/login")
	public MemberDto login(MemberDto dto) {
		System.out.println("MemberController login " + new Date());
		
		MemberDto mem = service.login(dto);
		System.out.println("mem : " + mem.getId() + mem.getPassword());
		return mem;
	}
	
	// 회원정보 수정 4/12 김건우
	@PostMapping(value = "/changeInfo")
	public String changeInfo(MemberDto dto) {
		System.out.println("MemberController changeInfo " + new Date());
		
		boolean b = service.changeInfo(dto);
		if(b == false) {
			return "NO";
		}
		return "YES";
	}
	
	
	
	

}
