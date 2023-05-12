package com.woojujumin.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.woojujumin.dto.BbsCountDto;
import com.woojujumin.dto.FreeBbsDto;
import com.woojujumin.dto.FreeReplyDto;
import com.woojujumin.dto.MemberDto;
import com.woojujumin.dto.PartyBbsDto;
import com.woojujumin.dto.PartyReplyDto;
import com.woojujumin.dto.SpamWordDto;
import com.woojujumin.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	AdminService service;

	// 스팸단어 리스트
	@GetMapping(value = "allSpamWord")
	public List<SpamWordDto> allSpamWord() {
		System.out.println("Admin Controller allSpamWord : " + new Date());
		return service.allSpamWord();
	}

	// 스팸단어추가
	@PostMapping(value = "addSpamword")
	public String addSpamword(String word) {
		System.out.println("Admin Controller addSpamword : " + new Date());
		System.out.println("word : " + word);
		boolean b = service.addSpamword(word);
		if (b == false) {
			return "NO";
		}
		return "YES";
	}

	// 스팸단어삭제
	@PostMapping(value = "deleteSpamword")
	public String deletSpamword(String word) {
		System.out.println("AdminController deleteSpamword : " + new Date());
		System.out.println("word : " + word);
		boolean b = service.deleteSpamword(word);
		if (b == false) {
			return "NO";
		}
		return "YES";
	}

	@GetMapping(value = "freebbsSpamlist")
	public List<FreeBbsDto> freebbsSpamlist() {
		System.out.println("Admin Controller freebbsSpamlist : " + new Date());
		return service.freebbsSpamlist();
	}

	@GetMapping(value = "partybbsSpamlist")
	public List<PartyBbsDto> partybbsSpamlist() {
		System.out.println("Admin Controller partybbsSpamlist : " + new Date());
		return service.partybbsSpamlist();
	}

	// 모집게시판 리스트(어드민)
	@GetMapping(value = "PartyBbslistAdmin")
	public List<PartyBbsDto> PartyBbslistAdmin(@RequestParam(required = false) String choice,
			@RequestParam(required = false) String search, int start, @RequestParam(required = false) Integer tag) {
		System.out.println("adminController PartyBbslistAdmin : " + new Date());
		System.out.println("choice: " + choice + "  search: " + search + "  start: " + start + " tag : " + tag);
		return service.PartyBbslistAdmin(choice, search, start, tag);
	}

	@GetMapping(value = "cntPartyBbsAdmin")
	public int cntPartyBbsAdmin(@RequestParam(required = false) String choice,
			@RequestParam(required = false) String search, @RequestParam(required = false) Integer tag) {
		System.out.println("adminController cntPartyBbsAdmin : " + new Date());
		System.out.println("choice: " + choice + "  search: " + search + " tag : " + tag);
		System.out.println(service.cntPartyBbsAdmin(choice, search, tag));
		return service.cntPartyBbsAdmin(choice, search, tag);
	}

	@GetMapping("getPartyBbsAdmin")
	public PartyBbsDto getPartyBbsAdmin(int partySeq) {
		return service.getPartyBbsAdmin(partySeq);
	}

	@PostMapping(value = "delFreebbsByAdmin")
	public String delFreebbsByAdmin(int bbsSeq) {
		System.out.println("adminController delFreebbsByAdmin() " + new Date());

		boolean b = service.delFreebbsByAdmin(bbsSeq);
		if (b == false) {
			return "NO";
		}
		return "YES";
	}

	@PostMapping(value = "reopenFreebbsByAdmin")
	public String reopenFreebbsByAdmin(int bbsSeq) {
		System.out.println("adminController reopenFreebbsByAdmin() " + new Date());

		boolean b = service.reopenFreebbsByAdmin(bbsSeq);
		if (b == false) {
			return "NO";
		}
		return "YES";
	}

	@PostMapping(value = "delPartybbsByAdmin")
	public String delPartybbsByAdmin(int partySeq) {
		System.out.println("adminController delPartybbsByAdmin() " + new Date());
		System.out.println("partySeq : " + partySeq);

		boolean b = service.delPartybbsByAdmin(partySeq);
		System.out.println(b);
		if (b == false) {
			return "NO";
		}
		return "YES";
	}

	@PostMapping(value = "reopenPartybbsByAdmin")
	public String reopenPartybbsByAdmin(int partySeq) {
		System.out.println("adminController reopenPartybbsByAdmin() " + new Date());
		System.out.println("partySeq : " + partySeq);
		boolean b = service.reopenPartybbsByAdmin(partySeq);

		if (b == false) {
			return "NO";
		}
		return "YES";
	}

	@GetMapping(value = "getMemlistByAuth")
	public List<MemberDto> getMemlistByAuth(int auth) {
		System.out.println("adminController getMemlistByAuth() " + new Date());
		return service.getMemlistByAuth(auth);
	}

	@GetMapping(value = "getMemeberInfo")
	public MemberDto getMemeberInfo(int memberSeq) {
		System.out.println("adminController getMemeberInfo() " + new Date());
		return service.getMemeberInfo(memberSeq);
	}
	@PostMapping(value = "stateControl")
	public String  stateControl(int auth, int memberSeq){
		System.out.println("adminController stateControl() " + new Date());

		boolean b = service.stateControl(auth,memberSeq);

		if (b == false) {
			return "NO";
		}
		return "YES";
	}
	
	//관리자페이지 7일간 모집게시판 등록수
	@GetMapping(value ="cntFbsDays")
	public List<BbsCountDto> cntFbsDays(){
		System.out.println("PartyBbsController cntFbsDays : " + new Date());
		return service.cntFbsDays();
	}
	
	@GetMapping(value ="freeBbsSpamReply")
	public List<FreeReplyDto> freeBbsSpamReply(){
		System.out.println("PartyBbsController freeBbsSpamReply : " + new Date());
		return service.freeBbsSpamReply();
	}
	
	@GetMapping(value ="partyBbsSpamReply")
	public  List<PartyReplyDto> partyBbsSpamReply(){
		System.out.println("PartyBbsController partyBbsSpamReply : " + new Date());
		return service.partyBbsSpamReply();
	}
	@GetMapping(value ="partyReplyListAdmin")
	public List<PartyReplyDto> partyReplyListAdmin(int replySeq, int start, int limit){
		System.out.println("PartyBbsController partyReplyListAdmin : " + new Date());
		return service.partyReplyListAdmin(replySeq,start,limit);
	}
	@PostMapping(value = "stateFreeReplyControl")
	public String stateFreeReplyControl( int seq, int replySeq, int del){
		System.out.println("adminController stateFreeReplyControl() " + new Date()); 

		boolean b = service.stateFreeReplyControl( seq,replySeq,del);

		if (b == false) {
			return "NO";
		}
		return "YES";
	}
	@PostMapping(value = "statePartyReplyControl")
	public String statePartyReplyControl( int seq, int replySeq, int del){
		System.out.println("adminController statePartyReplyControl() " + new Date()); 
		
		boolean b = service.statePartyReplyControl(seq,replySeq,del);
		
		if (b == false) {
			return "NO";
		}
		return "YES";
	}
	
	
}
