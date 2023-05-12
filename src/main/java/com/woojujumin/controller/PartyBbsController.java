package com.woojujumin.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import com.woojujumin.dto.BbsCountDto;
import com.woojujumin.dto.ApplyDto;
import com.woojujumin.dto.FreeBbsDto;
import com.woojujumin.dto.PartyBbsDto;
import com.woojujumin.dto.mypartyBbsParam;
import com.woojujumin.service.PartyBbsService;

@RestController
public class PartyBbsController {

	@Autowired
	PartyBbsService service;
	
	// 4/13 내가 쓴 게시판(파티모집)
	@GetMapping(value = "/myBbslist")
	public Map<String, Object> bbslist(mypartyBbsParam param) {

		System.out.println("BbsController bbslist : " + new Date());
		System.out.println("id" +param.getId());

		// 글의 시작과 끝
		int pn = param.getPageNumber(); // 0 1 2 3 4
		int start = 1 + (pn * 10); // 1 11
		int end = (pn + 1) * 10; // 10 20
		System.out.println("pn" +pn);

		param.setStart(start);
		param.setEnd(end);
		System.out.println("search"+ param.getSearch());

		List<PartyBbsDto> list = service.myBbslist(param);
		
		int len = service.getmyAllBbs(param);
		
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", len);

		return map;
	}
	
	@PostMapping(value = "/writePartybbs")
	public String writePartybbs(PartyBbsDto dto, ApplyDto adto ) {
		
		System.out.println("BbsController writePartybbs : " + new Date());
		System.out.println(dto.toString());
		boolean b = service.writePartybbs(dto);
		
		PartyBbsDto dtos = service.getSeq(dto);// seq select으로 받아오기
		System.out.println(dtos.toString());
		adto.setApplyMem(dtos.getId());
		adto.setMasterId(dtos.getId());
		adto.setTitle(dtos.getTitle());
		adto.setWdate(dtos.getWdate());
		adto.setTotalMem((byte)dtos.getPeople());
		adto.setPartySeq(dtos.getPartySeq());
		
		System.out.println("fewfewfewfew" + adto.getPartySeq());
		service.insertPartyJang(adto);
		if(b == false) {
			return "NO";
		}
		
		return "YES";
	}
	
	@GetMapping(value = "/partyBbsdetail")
	public PartyBbsDto partyBbsdetail(PartyBbsDto dto) {
		System.out.println("BbsController partyBbsdetail : " + new Date());
		System.out.println(dto.getPartySeq());
		PartyBbsDto detail = service.partyBbsdetail(dto);
		System.out.println("dto :" +detail.toString());
	
		return detail;
	}
	
	@PostMapping(value = "/deletePartybbs")
	public String deletePartybbs(PartyBbsDto dto) {
		System.out.println("BbsController deletePartybbs : " + new Date());
		
		boolean b = service.deletePartybbs(dto);
		if(b == false) {
			return "NO";
		}
		
		return "YES";
	}
	@GetMapping(value = "/getRow")
	public String getRow(ApplyDto dto) {
		System.out.println("BbsController getRow : " + new Date());
		
		List<ApplyDto> list = service.getRow(dto);
		List<ApplyDto> lists = service.getFullRow(dto);
		
		System.out.println("list : " + list);
		System.out.println("lists : " + lists);
		System.out.println("dsfewf" + lists.get(0).getFull());
	
		if (!list.isEmpty() || lists.get(0).getFull() == 1) {
			
			System.out.println("욤?");
			return "YES";
		}
		
		return "NO";
		
	}
	
	
	@GetMapping(value = "/partybbslist")
	public Map<String, Object> partybbslist(){
		System.out.println("BbsController partybbslist : " + new Date());
		
		List<PartyBbsDto> list = service.partybbslist();
		
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		
		return map;
	}
	// 파티 요청시 등록해주는거
	@PostMapping(value = "/partyApply")
	public String partyApply(ApplyDto dto){
		System.out.println("BbsController partyApply : " + new Date());
	
		System.out.println(dto.toString());
		
		
		boolean b = service.partyApply(dto);
		ApplyDto dtos = service.getCountMem(dto);// select로 countMem 갖고오기
		
		System.out.println("dtos : " + dtos.getCountMem());
		
		boolean c = service.updateCountMem(dtos);// 갖고온 countMem 으로 update
		
		System.out.println("나오니>????" + c);
		
		if(b == false) {
			return "NO";
		}
		
		return "YES";
	}

	
	@PostMapping(value = "/updatePartybbs")
	public String updatePartybbs(PartyBbsDto dto) {
		System.out.println("BbsController updatePartybbs : " + new Date());
		
		boolean b = service.updatePartybbs(dto);
		
		if(b == false) {
			return "NO";
		}
		
		return "YES";
	}
	
	@GetMapping(value = "/getAllpbslist")
	public Map<String, Object> getAllpbslist(mypartyBbsParam param) {

		System.out.println("BbsController getAllpbslist : " + new Date());
		

		// 글의 시작과 끝
		int pn = param.getPageNumber(); // 0 1 2 3 4
		int start = 1 + (pn * 5); // 1 11
		int end = (pn + 1) * 5; // 10 20
		System.out.println("pn" +pn);

		param.setStart(start);
		param.setEnd(end);

		List<PartyBbsDto> list = service.getAllpbslist(param);
		
		
//		int pageBbs = len / 10;		// 25 / 10 -> 2
//		if((len % 10) > 0) {
//			pageBbs = pageBbs + 1;
//		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
	//	map.put("pageBbs", pageBbs);
		return map;
	}

	
}
