package com.woojujumin.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.woojujumin.dto.MemberDto;
import com.woojujumin.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;

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
	
	// 닉네임 체크
	@PostMapping(value = "/nickcheck")
	public String nickcheck(String nickname) {
		System.out.println("MemberController nickcheck " + new Date());
		
		boolean b = service.nickcheck(nickname);
		if(b == true) {
			return "NO";
		}
		
		return "YES";
	}
	
	// 회원가입
	@PostMapping(value = "/addmember")
	public String addmember(MemberDto dto,
							@RequestParam("uploadFile")
							MultipartFile uploadFile,
							HttpServletRequest req) {
		System.out.println("MemberController addmember " + new Date());
		System.out.println(dto.toString());
		
		// 경로
		String path = req.getServletContext().getRealPath("/upload");
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
		dto.setProfile(filepath);
		
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
	public String changeInfo(MemberDto dto,
							 @RequestParam("uploadFile")
							 MultipartFile uploadFile,
							 HttpServletRequest req) {
		
		System.out.println("MemberController changeInfo " + new Date());
		// 경로
		String path = req.getServletContext().getRealPath("/upload");
		String filename = uploadFile.getOriginalFilename();
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
		dto.setProfile(filepath);
		System.out.println(dto.toString());	
		
		boolean b = service.changeInfo(dto);
		if(b == false) {
			return "NO";
		}
		return "YES";
	}
	
	
	
	

}
