package com.woojujumin.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.lang.model.util.Elements;

import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woojujumin.naver.CrawlingClass;

@RestController
public class CrawlingController {
	
	@Autowired
	CrawlingClass craw;
	
	@GetMapping("/movicechart")
	public HashMap<String, Object> movicechart() throws Exception{
		System.out.println("CrawlingController movicechart() " + new Date());
		
		Elements movie = (Elements) craw.moveCrawling();
		
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("movie", movie);
		
		return map;
	}
}
