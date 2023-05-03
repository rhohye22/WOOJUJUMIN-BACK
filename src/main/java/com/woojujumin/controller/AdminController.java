package com.woojujumin.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woojujumin.dto.FreeBbsDto;
import com.woojujumin.dto.PartyBbsDto;
import com.woojujumin.dto.SpamWordDto;
import com.woojujumin.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	AdminService service;

	//스팸단어 리스트
	@GetMapping(value = "allSpamWord")
	public List<SpamWordDto> allSpamWord(){
		System.out.println("Admin Controller allSpamWord : " + new Date());
		return service.allSpamWord();
	}
	
	//스팸단어추가
	@PostMapping(value = "addSpamword")
	public String addSpamword(String word) {
		System.out.println("Admin Controller addSpamword : " + new Date());
		System.out.println("word : "+word);
		boolean b = service.addSpamword(word);
		if (b == false) {
			return "NO";
		}
		return "YES";
	}
	//스팸단어삭제
	@PostMapping(value = "deleteSpamword")
	public String deletSpamword(String word) {
		System.out.println("AdminController deleteSpamword : " + new Date());
		System.out.println("word : "+word);
		boolean b = service.deleteSpamword(word);
		if (b == false) {
			return "NO";
		}
		return "YES";
	}
	
	@GetMapping(value = "freebbsSpamlist")
	public List<FreeBbsDto> freebbsSpamlist(){
		System.out.println("Admin Controller freebbsSpamlist : " + new Date());
		return service.freebbsSpamlist();
	}
	@GetMapping(value = "partybbsSpamlist")
	public List<PartyBbsDto> partybbsSpamlist(){
		System.out.println("Admin Controller partybbsSpamlist : " + new Date());
		return service.partybbsSpamlist();
	}
}
