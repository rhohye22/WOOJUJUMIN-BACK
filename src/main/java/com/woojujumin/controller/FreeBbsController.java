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

import com.woojujumin.dto.BbsCountDto;
import com.woojujumin.dto.FreeBbsDto;
import com.woojujumin.dto.MemberDto;
import com.woojujumin.dto.FreeReplyDto;
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
		System.out.println("id" + param.getId());

		// 글의 시작과 끝
		int pn = param.getPageNumber(); // 0 1 2 3 4
		int start = 1 + (pn * 10); // 1 11
		int end = (pn + 1) * 10; // 10 20
		System.out.println("pn" + pn);

		param.setStart(start);
		param.setEnd(end);

		List<FreeBbsDto> list = service.myfreeBbslist(param);

		int len = service.getmyfreeAllBbs(param);

		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", len);

		return map;

	}

	// 자유게시판 리스트
	@GetMapping(value = "freeBbslist")
	public List<FreeBbsDto> freeBbslist(@RequestParam(required=false)String choice, @RequestParam(required=false)String search, int start,@RequestParam(required=false)Integer  tag) {
		System.out.println("FreeBbsController freeBbslist : " + new Date());
		//System.out.println("choice: " + choice + "  search: " + search + "  start: " + start+ " tag : "+tag);
		return service.freeBbslist(choice, search, start,tag);
	}

	@GetMapping(value = "cntFreeBbs")
	public int cntFreeBbs(@RequestParam(required=false)String choice, @RequestParam(required=false)String search,@RequestParam(required=false)Integer  tag) {
		System.out.println("FreeBbsController cntFreeBbs : " + new Date());
		//System.out.println("choice: " + choice + "  search: " + search+" tag : "+tag);
		//System.out.println(service.cntFreeBbs(choice, search,tag));
		return service.cntFreeBbs(choice, search,tag);
	}

	@PostMapping(value = "writeFreeBbs")
	public String writeFreeBbs(FreeBbsDto dto,
			@RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile, HttpServletRequest req) {
		System.out.println("FreeBbsController writeFreeBbs " + new Date());
		//System.out.println(dto.toString());

		// 경로

		String path = "/root/tmp/image/upload/freebbs";
		System.out.println(path);

		//올리는 사진이 있으면
		if (uploadFile != null && !uploadFile.isEmpty()) {
			String filename = uploadFile.getOriginalFilename();
			//System.out.println(filename);

			String filepath = path + "/" + filename;
			//System.out.println(filepath);

			try {
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
				bos.write(uploadFile.getBytes());
				bos.close();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("파일 업로드 실패");
			}
			dto.setImage(filename);
		//사진이 없으면
		} else {
			String filename = null;
			dto.setImage(filename);
		}
		boolean b = service.writeFreeBbs(dto);
		if (b == false) {
			return "NO";
		}
		return "YES";
	}
	@PostMapping(value = "modifyFreebbs")
	public String modifyFreebbs(FreeBbsDto dto,
			@RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile, HttpServletRequest req) {
		System.out.println("FreeBbsController writeFreeBbs " + new Date());
	
		//수정전 데이터
		FreeBbsDto predto = service.getfreeBbs(dto.getBbsSeq());
		// 경로
		String path = req.getServletContext().getRealPath("/upload/freebbs");
		//System.out.println(path);
		//올리는 사진이 있고 기존사진과 다르면
		if (uploadFile != null && !uploadFile.isEmpty() && predto.getImage() != dto.getImage()) {
			String filename = uploadFile.getOriginalFilename();
			System.out.println(filename);
			
			String filepath = path + "/" + filename;
			System.out.println(filepath);
			//System.out.println("올리는 사진이 있고 기존사진과 다르면 dto.getImage() : "+dto.getImage());
			try {
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
				bos.write(uploadFile.getBytes());
				bos.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("파일 업로드 실패");
			}
			dto.setImage(filename);
		
		} 
		//기존에 사진이 있었는데 수정후에는 없다면	
		else if( predto.getImage() != null && (dto.getImage() == null || dto.getImage().trim().isEmpty())){
			//System.out.println("기존에 사진이 있었는데 수정후에는 없다면 dto.getImage() : "+dto.getImage());
			String filename = null;
			dto.setImage(filename);
			
			//기존 사진을 삭제하고 싶다면 
			//String filePath = path + "/" + predto.getImage();
			//File file = new File(filePath);
			//if (file.exists()) {
			//	file.delete();
			//}
					
		} 
		//사진은 수정없이 그대로면
		else {
			String filename = predto.getImage();
			dto.setImage(filename);
			//System.out.println("사진은 수정없이 그대로면 ");
		}
		boolean b = service.modifyFreebbs(dto);
		if (b == false) {
			return "NO";
		}
		return "YES";
	}

	@GetMapping("getfreeBbs")
	public FreeBbsDto getfreeBbs(int bbsSeq) {
		return service.getfreeBbs(bbsSeq);
	}

	// 자유게시판 글삭제
	@PostMapping(value = "delFeebbsByWriter")
	public String delFeebbsByWriter(int bbsSeq) {
		System.out.println("FreeBbsController delFeebbsByWriter() " + new Date());
	
		boolean b = service.delFeebbsByWriter(bbsSeq);
		if (b == false) {
			return "NO";
		}
		return "YES";
	}
	// 자유게시판 댓글
	@PostMapping(value = "writeFreeReply")
	public String writeFreeReply(FreeReplyDto dto) {
		System.out.println("FreeBbsController writeFreeReply() " + new Date());
	
		boolean b = service.writeFreeReply(dto);
		if (b == false) {
			return "NO";
		}
		return "YES";
	}

	// 자유게시판 댓글 리스트
	@GetMapping(value = "freeReplyList")
	public List<FreeReplyDto> freeReplyList(int replySeq, int start, int limit) {
		System.out.println("FreeBbsController freeReplyList : " + new Date());
		System.out.println("replySeq: " + replySeq + " start: " + start + " limit: " + limit);
		return service.freeReplyList(replySeq, start, limit);
	}

	// 좋아요

	// likey테이블에 bbsSeq, memSeq조건을 만족하는 로우가 있는지 확인
	@GetMapping(value = "checkLikeyrow")
	public int checkLikeyrow(int bbsSeq, int memSeq) {
		//System.out.println("FreeBbsController checkLikeyrow : " + new Date());
		//System.out.println("checkLikeyrow : bbsSeq: " + bbsSeq + " memSeq: " + memSeq);
		return service.checkLikeyrow(bbsSeq, memSeq);
	}

	// likey테이블에 로우 삽입
	@PostMapping(value = "makeLikeyrow")
	public String makeLikeyrow(int bbsSeq, int memSeq) {
		//System.out.println("FreeBbsController makeLikeyrow() " + new Date());

		boolean b = service.makeLikeyrow(bbsSeq, memSeq);
		if (b == false) {
			return "NO";
		}
		return "YES";
	}

	// 좋아요 1
	@PostMapping(value = "LikeyPlus")
	public String LikeyPlus(int bbsSeq, int memSeq) {
		//System.out.println("FreeBbsController LikeyPlus() " + new Date());

		boolean b = service.LikeyPlus(bbsSeq, memSeq);
		if (b == false) {
			return "NO";
		}
		return "YES";
	}

	// 좋아요 0(==좋아요 취소)
	@PostMapping(value = "LikeyMinus")
	public String LikeyMinus(int bbsSeq, int memSeq) {
		//System.out.println("FreeBbsController LikeyMinus() " + new Date());

		boolean b = service.LikeyMinus(bbsSeq, memSeq);
		if (b == false) {
			return "NO";
		}
		return "YES";
	}

	// 입장시 페이지 좋아요 상태
	@GetMapping(value = "LikeyState")
	public int LikeyState(int bbsSeq, int memSeq) {
		//System.out.println("FreeBbsController LikeyState : " + new Date());
		//System.out.println("LikeyState : bbsSeq: " + bbsSeq + " memSeq: " + memSeq);
		return service.LikeyState(bbsSeq, memSeq);
	}

	// 게시글당 좋아요 개수
	@GetMapping(value = "cntLikey")
	public int cntLikey(int bbsSeq) {
		//System.out.println("FreeBbsController cntLikey : " + new Date());
		//System.out.println("cntLikey : bbsSeq: " + bbsSeq);
		return service.cntLikey(bbsSeq);
	}

	
	//조회수
	// read테이블에 bbsSeq, memSeq조건을 만족하는 로우가 있는지 확인
	@GetMapping(value = "checkReadrow")
	public int checkReadrow(int bbsSeq, int memSeq) {
		//System.out.println("FreeBbsController checkReadrow : " + new Date());
		System.out.println("checkReadrow : bbsSeq: " + bbsSeq + " memSeq: " + memSeq);
		
		return service.checkLikeyrow(bbsSeq, memSeq);
	}
	
	// read테이블에 로우 삽입
		@PostMapping(value = "makeReadrow")
		public String makeReadrow(int bbsSeq, int memSeq) {
			//System.out.println("FreeBbsController makeReadrow() " + new Date());
			System.out.println("makeReadrow : bbsSeq: " + bbsSeq + " memSeq: " + memSeq);
		
			boolean b = service.makeReadrow(bbsSeq, memSeq);
			if (b == false) {
				return "NO";
			}
			return "YES";
		}
		//게시글당 조회수
		@GetMapping(value = "cntRead")
		public int cntRead(int bbsSeq) {
			System.out.println("FreeBbsController cntRead : " + new Date());
			System.out.println("cntRead :  bbsSeq: " + bbsSeq);
			return service.cntRead(bbsSeq);
		}

	//관리자페이지 7일간 자유게시판 등록수
		@GetMapping(value ="cntBbsDays")
		public List<BbsCountDto> cntBbsDays(){
			System.out.println("FreeBbsController cntBbsDays : " + new Date());
			return service.cntBbsDays();
		}
		//최근 30일간 일별 가입한 회원수
		@GetMapping(value ="cntRegiMemDays")
		public List<BbsCountDto> cntRegiMemDays(){
			System.out.println("FreeBbsController cntRegiMemDays : " + new Date());
			return service.cntRegiMemDays();
		}
}
