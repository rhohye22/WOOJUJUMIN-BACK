package com.woojujumin.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.woojujumin.dto.FreeBbsDto;
import com.woojujumin.dto.MemberDto;
import com.woojujumin.dto.QnaDto;
import com.woojujumin.dto.mypartyBbsParam;
import com.woojujumin.service.FreeBbsService;

import jakarta.servlet.http.HttpServletRequest;



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

		//자유게시판 리스트
		@GetMapping(value = "freeBbslist")
		public List<FreeBbsDto> freeBbslist(String choice, String search, int start){
			System.out.println("FreeBbsController freeBbslist : " + new Date());
			System.out.println("choice: "+choice+"  search: "+search+"  start: "+start);
			return service.freeBbslist(choice, search,start);
		}
		
		@GetMapping(value = "cntFreeBbs")
		public int cntFreeBbs(String choice, String search){
			System.out.println("FreeBbsController cntFreeBbs : " + new Date());
			System.out.println("choice: "+choice+"  search: "+search);
			return service.cntFreeBbs(choice, search);
		}
		
		
		@PostMapping(value = "writeFreeBbs")
		public String writeFreeBbs(FreeBbsDto dto,
								@RequestParam("uploadFile")
								MultipartFile uploadFile,
								HttpServletRequest req) {
			System.out.println("FreeBbsController writeFreeBbs " + new Date());
			System.out.println(dto.toString());
			
			// 경로
			String path = req.getServletContext().getRealPath("/upload/freebbs");
			System.out.println(path);
			
			String filename = uploadFile.getOriginalFilename();
			System.out.println(filename);
			/*
			if(filename == null || filename.equals("")) {
				
			}*/
			
			String filepath = path + "/" + filename;
			System.out.println(filepath);
			
			try {
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
				bos.write(uploadFile.getBytes());
				bos.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("파일 업로드 실패");
			}
			dto.setImage(filepath);
			
			boolean b = service.writeFreeBbs(dto);
			if(b == false) {
				return "NO";
			}
			return "YES";
		}
		
			@GetMapping("getfreeBbs")
		public FreeBbsDto getfreeBbs(int bbsSeq) {
			return service.getfreeBbs(bbsSeq);
		}
		
		//사용 확인필요
		
		
		@GetMapping("getAllList")
		public List<FreeBbsDto> getAllList() {
			return service.getAllList();
		}
		
		

	

}

