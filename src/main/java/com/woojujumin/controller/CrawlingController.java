package com.woojujumin.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.lang.model.util.Elements;

import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woojujumin.dto.TalkDto;
import com.woojujumin.naver.CrawlingClass;
import com.woojujumin.service.MemberService;

@RestController
public class CrawlingController {
	
	@GetMapping("/moviechart")
	public HashMap<String, Object> cgvmoviechart() throws Exception{
		System.out.println("CrawlingController cgvmoviechart() " + new Date());
		
		CrawlingClass craw = new CrawlingClass();
		return craw.cgvmovieCrawling();		
		
		
	}
	
	@GetMapping("/bookchart")
	public HashMap<String, Object> aladinbookchart() throws Exception{
		System.out.println("CrawlingController aladinbookchart() " + new Date());
		
		CrawlingClass craw = new CrawlingClass();
		return craw.aladinCrawling();
				
	}
	
	@GetMapping("/localevent")
	public HashMap<String, Object> localevent() throws Exception{
		System.out.println("CrawlingController localevent() " + new Date());
		
		CrawlingClass craw = new CrawlingClass();
		
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("onepage", craw.localOneCrawling());
		map.put("twopage", craw.localTwoCrawling());
		map.put("threepage", craw.localThreeCrawling());

		return map;
	}
	
	@GetMapping(value="/musicchart")
	public HashMap<String, Object> musicchart() throws Exception{
		System.out.println("CrawlingController musicchart() " + new Date());
		
		CrawlingClass craw = new CrawlingClass();
		
		return craw.musicCrawling();
	}
	
	@Autowired
	MemberService service;
	
	@PostMapping(value="/talkcomment")
	public String talkcomment(TalkDto talk) {
		System.out.println("CrawlingController talkcomment() " + new Date());
		System.out.println("넘어온 값 talk : " + talk);
		
		boolean isS  = service.talkcomment(talk);
		if(isS) return "YES";
		return "NO";
		
	}
	
	@GetMapping(value="/alltalkcomment")
	public List<TalkDto> alltalkcomment(TalkDto talk){
		System.out.println("CrawlingController alltalkcomment() " + new Date());
		System.out.println("넘어온 값 talk : " + talk);
		
		return service.alltalkcomment(talk);
	}
}
