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
	public List<FreeBbsDto> freeBbslist(String choice, String search, int start) {
		System.out.println("FreeBbsController freeBbslist : " + new Date());
		System.out.println("choice: " + choice + "  search: " + search + "  start: " + start);
		return service.freeBbslist(choice, search, start);
	}

	@GetMapping(value = "cntFreeBbs")
	public int cntFreeBbs(String choice, String search) {
		System.out.println("FreeBbsController cntFreeBbs : " + new Date());
		System.out.println("choice: " + choice + "  search: " + search);
		return service.cntFreeBbs(choice, search);
	}

	@PostMapping(value = "writeFreeBbs")
	public String writeFreeBbs(FreeBbsDto dto,
			@RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile, HttpServletRequest req) {
		System.out.println("FreeBbsController writeFreeBbs " + new Date());
		System.out.println(dto.toString());

		// 경로
		String path = req.getServletContext().getRealPath("/upload/freebbs");
		System.out.println(path);
		if (uploadFile != null && !uploadFile.isEmpty()) {
			String filename = uploadFile.getOriginalFilename();
			System.out.println(filename);

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
			dto.setImage(filename);
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

	@GetMapping("getfreeBbs")
	public FreeBbsDto getfreeBbs(int bbsSeq) {
		return service.getfreeBbs(bbsSeq);
	}

	// 자유게시판 댓글
	@PostMapping(value = "writeFreeReply")
	public String writeFreeReply(FreeReplyDto dto) {
		System.out.println("FreeBbsController writeFreeReply() " + new Date());
		System.out.println(dto.toString());
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
		System.out.println("FreeBbsController checkLikeyrow : " + new Date());
		System.out.println("checkLikeyrow : bbsSeq: " + bbsSeq + " memSeq: " + memSeq);
		return service.checkLikeyrow(bbsSeq, memSeq);
	}

	// likey테이블에 로우 삽입
	@PostMapping(value = "makeLikeyrow")
	public String makeLikeyrow(int bbsSeq, int memSeq) {
		System.out.println("FreeBbsController makeLikeyrow() " + new Date());

		boolean b = service.makeLikeyrow(bbsSeq, memSeq);
		if (b == false) {
			return "NO";
		}
		return "YES";
	}

	// 좋아요 1
	@PostMapping(value = "LikeyPlus")
	public String LikeyPlus(int bbsSeq, int memSeq) {
		System.out.println("FreeBbsController LikeyPlus() " + new Date());

		boolean b = service.LikeyPlus(bbsSeq, memSeq);
		if (b == false) {
			return "NO";
		}
		return "YES";
	}

	// 좋아요 0(==좋아요 취소)
	@PostMapping(value = "LikeyMinus")
	public String LikeyMinus(int bbsSeq, int memSeq) {
		System.out.println("FreeBbsController LikeyMinus() " + new Date());

		boolean b = service.LikeyMinus(bbsSeq, memSeq);
		if (b == false) {
			return "NO";
		}
		return "YES";
	}

	// 입장시 페이지 좋아요 상태
	@GetMapping(value = "LikeyState")
	public int LikeyState(int bbsSeq, int memSeq) {
		System.out.println("FreeBbsController LikeyState : " + new Date());
		System.out.println("LikeyState : bbsSeq: " + bbsSeq + " memSeq: " + memSeq);
		return service.LikeyState(bbsSeq, memSeq);
	}

	// 게시글당 좋아요 개수
	@GetMapping(value = "cntLikey")
	public int cntLikey(int bbsSeq) {
		System.out.println("FreeBbsController cntLikey : " + new Date());
		System.out.println("cntLikey : bbsSeq: " + bbsSeq);
		return service.cntLikey(bbsSeq);
	}

}
