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

import com.woojujumin.dto.IdcardDto;
import com.woojujumin.dto.MemberDto;
import com.woojujumin.naver.NaverCloud;
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
	//	System.out.println(dto.toString());
		
		// 경로
	//	String path = req.getServletContext().getRealPath("/upload/member"); // 5/6 혜원 수정
	//	System.out.println(path);
		
		String filename = uploadFile.getOriginalFilename();
		System.out.println(filename);
		/*
		if(filename == null || filename.equals("")) {
			
		}*/
		
	//	String filepath = path + "/" + filename;
	//	System.out.println(filepath);
		
		try {
//			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
//			bos.write(uploadFile.getBytes());
//			bos.close();
			dto.setProfile(filename);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("파일 업로드 실패");
		}
		//dto.setProfile(filepath); 5/6 혜원 수정;
		
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
	//	System.out.println("mem : " + mem.getId() + mem.getPassword());
		return mem;
	}
	
	// 아이디 찾기
	@GetMapping(value = "/idsearch")
	public MemberDto idsearch(String email) {
		System.out.println("MemberController idsearch " + new Date());
		
		MemberDto dto = service.idsearch(email);
		
		return dto;
	}
	
	// 임시 비밀번호로 변경
	@PostMapping(value = "/pwdsearch")
	public String pwdsearch(MemberDto dto) {
		System.out.println("MemberController pwdsearch " + new Date());
		
		boolean isS = service.pwdsearch(dto);
		String msg = "NO";
		
		if(isS) {
			msg = "YES";
		}
		
		return msg;
	}
	
	// 회원정보 수정 4/12 김건우
	@PostMapping(value = "/changeInfo")
	public String changeInfo(MemberDto dto,
							 @RequestParam("uploadFile")
							 MultipartFile uploadFile,
							 HttpServletRequest req) {
		
		System.out.println("MemberController changeInfo " + new Date());
		// 경로
	//	String path = req.getServletContext().getRealPath("/upload/member");// 5/6 혜원 수정
		String filename = uploadFile.getOriginalFilename();
	//	String filepath = path + "/" + filename;
	//	System.out.println(filepath);	
		
		try {
//			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
//			bos.write(uploadFile.getBytes());
//			bos.close();
			dto.setProfile(filename);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("파일 업로드 실패");
		}
		// 5/6 혜원 수정
		//dto.setProfile(filepath);
	//	System.out.println(dto.toString());	
		
		boolean b = service.changeInfo(dto);
		if(b == false) {
			return "NO";
		}
		return "YES";
	}
	// 관리자 페이지 로그인(4/17노혜원)
	@PostMapping(value = "/adminLogin")
	public MemberDto adminLogin(MemberDto dto) {
		System.out.println("MemberController adminLogin " + new Date());

		MemberDto mem = service.adminLogin(dto);
		System.out.println("mem : " + mem.getId() + mem.getPassword());
		return mem;
	}
	
	// 관리자 등록 4/17
		@PostMapping(value = "/adminAddmember")
		public String adminAddmember(MemberDto dto,
								@RequestParam("uploadFile")
								MultipartFile uploadFile,
								HttpServletRequest req) {
			System.out.println("MemberController adminAddmember " + new Date());
			System.out.println(dto.toString());
			
			// 경로
		//	String path = req.getServletContext().getRealPath("/upload/member");
			String filename = uploadFile.getOriginalFilename();
		//	String filepath = path + "/" + filename;
		//	System.out.println(filepath);
			
			try {
//				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
//				bos.write(uploadFile.getBytes());
//				bos.close();
				dto.setProfile(filename);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("파일 업로드 실패");
			}
			
			boolean b = service.adminAddmember(dto);
			if(b == false) {
				return "NO";
			}
			return "YES";
		}
		
	// 관리자 파티장 승급페이지 - ocr 결과 보내주기 (권유리) - 230420
	@PostMapping(value="partyrequest")
	public String partyrequest_ocr(@RequestParam("uploadFile") MultipartFile uploadFile, 
									HttpServletRequest req) {
		System.out.println("MemberController partyrequest_ocr " + new Date());
		
		String uploadpath = req.getServletContext().getRealPath("/upload");

		String filename = uploadFile.getOriginalFilename();
		String filepath = uploadpath + "/" + filename;


		System.out.println(filepath);
		
		try {
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			os.write(uploadFile.getBytes());
			os.close();

		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		
		String result = NaverCloud.ocr(filepath);		
		return result;
	
	}

	// 관리자 파티장 승급 페이지 - 신청하기 230420
	@PostMapping(value="partyleader")
	public String adminPartyLeader(IdcardDto dto) {
		System.out.println("MemberController adminPartyLeader " + new Date());
		System.out.println("넘어온 값 : " + dto);
		
		boolean isS = service.adminPartyLeader(dto);
		if(isS) return "YES";
		return "NO";
		
	}
	
	// 관리자 파티장 승급 페이지 - 리스트 보여주기 230421 
	@PostMapping(value="partycheck")
	public List<IdcardDto> allcheck(){
		System.out.println("MemberController allcheck " + new Date());
		
		return service.allcheck();
		
	}
	
	// 관리자 파티장 승급 여부 - 230421 
	@PostMapping(value="partyleadersuccess")
	public String partyleadersuccess(String memid) {
		System.out.println("MemberController partyleadersuccess " + new Date());
		System.out.println("넘어온 값 memid : " + memid);
		
		boolean isS = service.partyleadersuccess(memid);
		if(isS) return "YES";
		return "NO";
	}

	// 소셜 회원가입
	@PostMapping(value = "/socialRegi")
	public String socialRegi(MemberDto dto) {
		System.out.println("MemberController socialRegi " + new Date());
		
		System.out.println(dto.toString());
		
		boolean b = service.addmember(dto);
		if(b == false) {
			return "NO";
		}
		return "YES";
	}

	// 소셜 로그인
	@PostMapping(value = "/socialLogin")
	public MemberDto socialLogin(String id) {
		System.out.println("MemberController socialLogin " + new Date());
		
		MemberDto mem = service.socialLogin(id);
		System.out.println("mem : " + mem.getId() + mem.getPassword());
		return mem;
	}
	
	// 소셜 회원가입 추가작업
	@PostMapping(value = "/socialAdd")
	public MemberDto socialAdd(MemberDto dto) {
		System.out.println("MemberController socialAdd " + new Date());
		
		MemberDto mem = new MemberDto();
		boolean b = service.socialAdd(dto);
		if(b == false) {
			return mem;
		}
		
		mem = service.socialLogin(dto.getId());
		return mem;

	}
	
	// 파티장 승인 결과 
	@GetMapping(value = "/partyleaderresult")
	public String partyleaderresult(String memid) {
		System.out.println("MemberController partyleaderresult " + new Date());
		System.out.println("넘어온 값 memid : " + memid);
		
		return service.partyleaderresult(memid);
	}
	
	@GetMapping(value="/partyleaderresultAll")
	public IdcardDto partyleaderresultAll(String memid) {
		System.out.println("MemberController partyleaderresultAll " + new Date());
		System.out.println("넘어온 값 memid : " + memid);
		
		return service.partyleaderresultAll(memid);
	}
	
	@PostMapping(value="/partyleaderreject")
	public String partyleaderreject(String memid) {
		System.out.println("MemberController partyleaderreject " + new Date());
		System.out.println("넘어온 값 memid : " + memid);
		
		boolean isS = service.partyleaderreject(memid);
		if(isS) return "YES";
		return "NO";
	}
	
	@GetMapping(value="/partyleaderreset")
	public String partyleaderreset(String memid) {
		System.out.println("MemberController partyleaderreset " + new Date());
		System.out.println("넘어온 값 memid : " + memid);
		
		boolean isS = service.partyleaderreset(memid);
		if(isS) return "YES";
		return "NO";
	}
}
