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
import com.woojujumin.dto.ApplyDto;
import com.woojujumin.dto.FreeBbsDto;
import com.woojujumin.dto.FreeReplyDto;
import com.woojujumin.dto.PartyBbsDto;
import com.woojujumin.dto.PartyReplyDto;
import com.woojujumin.dto.mypartyBbsParam;
import com.woojujumin.service.PartyBbsService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class PartyBbsController {

	@Autowired
	PartyBbsService service;

	// 4/13 내가 쓴 게시판(파티모집)
	@GetMapping(value = "/myBbslist")
	public Map<String, Object> bbslist(mypartyBbsParam param) {

		System.out.println("BbsController bbslist : " + new Date());
		System.out.println("id" + param.getId());

		// 글의 시작과 끝
		int pn = param.getPageNumber(); // 0 1 2 3 4
		int start = 1 + (pn * 10); // 1 11
		int end = (pn + 1) * 10; // 10 20
		System.out.println("pn" + pn);

		param.setStart(start);
		param.setEnd(end);
		System.out.println("search" + param.getSearch());

		List<PartyBbsDto> list = service.myBbslist(param);

		int len = service.getmyAllBbs(param);

		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", len);

		return map;
	}

	@PostMapping(value = "/writePartybbs")
	public String writePartybbs(PartyBbsDto dto, ApplyDto adto,
			@RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile, HttpServletRequest req) {

		System.out.println("BbsController writePartybbs : " + new Date());
		System.out.println(dto.toString());
		
		//String path = req.getServletContext().getRealPath("/upload/partybbs");
		//System.out.println(path);

		if (uploadFile != null && !uploadFile.isEmpty()) {
			String filename = uploadFile.getOriginalFilename();
			// System.out.println(filename);


			//String filepath = path + "/" + filename;
			//System.out.println(filepath);


			try {
//				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
//				bos.write(uploadFile.getBytes());
//				bos.close();
				dto.setImage(filename);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("파일 업로드 실패");
			}
			//dto.setImage(filename);
		} else {
			String filename = null;
			dto.setImage(filename);
		}

		boolean b = service.writePartybbs(dto);

		PartyBbsDto dtos = service.getSeq(dto);// seq select으로 받아오기
		System.out.println(dtos.toString());
		adto.setApplyMem(dtos.getId());
		adto.setMasterId(dtos.getId());
		adto.setTitle(dtos.getTitle());
		adto.setWdate(dtos.getWdate());
		adto.setTotalMem((byte) dtos.getPeople());
		adto.setPartySeq(dtos.getPartySeq());

		// System.out.println("fewfewfewfew" + adto.getPartySeq());
		service.insertPartyJang(adto);
		if (b == false) {
			return "NO";
		}

		return "YES";
	}

	@GetMapping(value = "/partyBbsdetail")
	public PartyBbsDto partyBbsdetail(PartyBbsDto dto) {
		System.out.println("BbsController partyBbsdetail : " + new Date());
		System.out.println(dto.getPartySeq());
		PartyBbsDto detail = service.partyBbsdetail(dto);
		System.out.println("dto :" + detail.toString());

		return detail;
	}

	@PostMapping(value = "/deletePartybbs")
	public String deletePartybbs(PartyBbsDto dto) {
		System.out.println("BbsController deletePartybbs : " + new Date());
		System.out.println("partySeq : " + dto.getPartySeq());

		boolean b = service.deletePartybbs(dto);
		if (b == false) {
			return "NO";
		}

		return "YES";
	}

	@GetMapping(value = "/getRow")
	public String getRow(ApplyDto dto) {
		System.out.println("BbsController getRow : " + new Date());

		List<ApplyDto> list = service.getRow(dto);
		List<ApplyDto> lists = service.getFullRow(dto);

		// System.out.println("list : " + list);
		// System.out.println("lists : " + lists);
		// System.out.println("dsfewf" + lists.get(0).getFull());

		if (!list.isEmpty() || lists.get(0).getFull() == 1) {

			// System.out.println("욤?");
			return "YES";
		}

		return "NO";

	}

	@GetMapping(value = "/partybbslist")
	public Map<String, Object> partybbslist() {
		System.out.println("BbsController partybbslist : " + new Date());

		List<PartyBbsDto> list = service.partybbslist();

		Map<String, Object> map = new HashMap<>();
		map.put("list", list);

		return map;
	}

	// 파티 요청시 등록해주는거
	@PostMapping(value = "/partyApply")
	public String partyApply(ApplyDto dto) {
		System.out.println("BbsController partyApply : " + new Date());

		System.out.println(dto.toString());

		boolean b = service.partyApply(dto);
		ApplyDto dtos = service.getCountMem(dto);// select로 countMem 갖고오기

		System.out.println("dtos : " + dtos.getCountMem());

		boolean c = service.updateCountMem(dtos);// 갖고온 countMem 으로 update

		System.out.println("나오니>????" + c);

		if (b == false) {
			return "NO";
		}

		return "YES";
	}

	@PostMapping(value = "/updatePartybbs")
	public String updatePartybbs(PartyBbsDto dto,
			@RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile, HttpServletRequest req) {
		System.out.println("BbsController updatePartybbs : " + new Date());

		// 수정전 데이터
		PartyBbsDto predto = service.partyBbsdetail(dto);
		// 경로

//		String path = req.getServletContext().getRealPath("/upload/partybbs");
		//System.out.println(path);
		//올리는 사진이 있고 기존사진과 다르면
		if (uploadFile != null && !uploadFile.isEmpty() && predto.getImage() != dto.getImage()) {
			String filename = uploadFile.getOriginalFilename();
			System.out.println(filename);
			
//			String filepath = path + "/" + filename;
//			System.out.println(filepath);
			//System.out.println("올리는 사진이 있고 기존사진과 다르면 dto.getImage() : "+dto.getImage());
			try {
//				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
//				bos.write(uploadFile.getBytes());
//				bos.close();
				dto.setImage(filename);

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("파일 업로드 실패");
			}

		} 
		//기존에 사진이 있었는데 수정후에는 없다면	
		else if( predto.getImage() != null && (dto.getImage() == null || dto.getImage().trim().isEmpty())){
			//System.out.println("기존에 사진이 있었는데 수정후에는 없다면 dto.getImage() : "+dto.getImage());

			String filename = null;
			dto.setImage(filename);

			// 기존 사진을 삭제하고 싶다면
			// String filePath = path + "/" + predto.getImage();
			// File file = new File(filePath);
			// if (file.exists()) {
			// file.delete();
			// }

		}
		// 사진은 수정없이 그대로면
		else {
			String filename = predto.getImage();
			dto.setImage(filename);
			// System.out.println("사진은 수정없이 그대로면 ");
		}
		boolean b = service.updatePartybbs(dto);
		if (b == false) {
			return "NO";
		}
		return "YES";
	}

	@GetMapping(value = "/getAllpbslist")
	public Map<String, Object> getAllpbslist(mypartyBbsParam param) {

		System.out.println("BbsController getAllpbslist : " + new Date());

		System.out.println(param.toString());
		// 글의 시작과 끝
		int pn = param.getPageNumber(); // 0 1 2 3 4
		int start = 1 + (pn * 10); // 1 11
		int end = (pn + 1) * 10; // 10 20
		System.out.println("pn" + pn);

		param.setStart(start);
		param.setEnd(end);

		List<PartyBbsDto> list = service.getAllpbslist(param);
		System.out.println(list.toString());

//		int pageBbs = len / 10;		// 25 / 10 -> 2
//		if((len % 10) > 0) {
//			pageBbs = pageBbs + 1;
//		}

		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		// map.put("pageBbs", pageBbs);
		return map;
	}

	// 요청인원
	@GetMapping("applyMemCnt")
	public int applyMemCnt(int partySeq) {
		System.out.println("BbsController applyMemCnt partySeq : " + partySeq);
		return service.applyMemCnt(partySeq);
	}

	// 확정인원
	@GetMapping("applyCheckMemCnt")
	public int applyCheckMemCnt(int partySeq) {
		return service.applyCheckMemCnt(partySeq);
	}

	// 좋아요

	// likey테이블에 bbsSeq, memSeq조건을 만족하는 로우가 있는지 확인
	@GetMapping(value = "partycheckLikeyrow")
	public int checkLikeyrow(int bbsSeq, int memSeq) {
		// System.out.println("FreeBbsController checkLikeyrow : " + new Date());
		// System.out.println("checkLikeyrow : bbsSeq: " + bbsSeq + " memSeq: " +
		// memSeq);
		return service.checkLikeyrow(bbsSeq, memSeq);
	}

	// likey테이블에 로우 삽입
	@PostMapping(value = "partymakeLikeyrow")
	public String makeLikeyrow(int bbsSeq, int memSeq) {
		// System.out.println("FreeBbsController makeLikeyrow() " + new Date());

		boolean b = service.makeLikeyrow(bbsSeq, memSeq);
		if (b == false) {
			return "NO";
		}
		return "YES";
	}

	// 좋아요 1
	@PostMapping(value = "partyLikeyPlus")
	public String LikeyPlus(int bbsSeq, int memSeq) {
		// System.out.println("FreeBbsController LikeyPlus() " + new Date());

		boolean b = service.LikeyPlus(bbsSeq, memSeq);
		if (b == false) {
			return "NO";
		}
		return "YES";
	}

	// 좋아요 0(==좋아요 취소)
	@PostMapping(value = "partyLikeyMinus")
	public String LikeyMinus(int bbsSeq, int memSeq) {
		// System.out.println("FreeBbsController LikeyMinus() " + new Date());

		boolean b = service.LikeyMinus(bbsSeq, memSeq);
		if (b == false) {
			return "NO";
		}
		return "YES";
	}

	// 입장시 페이지 좋아요 상태
	@GetMapping(value = "partyLikeyState")
	public int LikeyState(int bbsSeq, int memSeq) {
		// System.out.println("FreeBbsController LikeyState : " + new Date());
		// System.out.println("LikeyState : bbsSeq: " + bbsSeq + " memSeq: " + memSeq);
		return service.LikeyState(bbsSeq, memSeq);
	}

	// 게시글당 좋아요 개수
	@GetMapping(value = "partycntLikey")
	public int cntLikey(int bbsSeq) {
		// System.out.println("FreeBbsController cntLikey : " + new Date());
		// System.out.println("cntLikey : bbsSeq: " + bbsSeq);
		return service.cntLikey(bbsSeq);
	}

	// 자유게시판 댓글
	@PostMapping(value = "writepartyReply")
	public String writepartyReply(PartyReplyDto dto) {
		System.out.println("partyBbsController writepartyReply() " + new Date());

		boolean b = service.writepartyReply(dto);
		if (b == false) {
			return "NO";
		}
		return "YES";
	}

	// 자유게시판 댓글 리스트
	@GetMapping(value = "partyReplyList")
	public List<PartyReplyDto> partyReplyList(int replySeq, int start, int limit) {
		System.out.println("partyBbsController partyReplyList : " + new Date());
		System.out.println("replySeq: " + replySeq + " start: " + start + " limit: " + limit);
		return service.partyReplyList(replySeq, start, limit);
	}

	// 조회수
	// read테이블에 bbsSeq, memSeq조건을 만족하는 로우가 있는지 확인
	@GetMapping(value = "partycheckReadrow")
	public int checkReadrow(int bbsSeq, int memSeq) {
		// System.out.println("FreeBbsController checkReadrow : " + new Date());
		System.out.println("checkReadrow : bbsSeq: " + bbsSeq + " memSeq: " + memSeq);

		return service.checkLikeyrow(bbsSeq, memSeq);
	}

	// read테이블에 로우 삽입
	@PostMapping(value = "partymakeReadrow")
	public String makeReadrow(int bbsSeq, int memSeq) {
		// System.out.println("FreeBbsController makeReadrow() " + new Date());
		System.out.println("makeReadrow : bbsSeq: " + bbsSeq + " memSeq: " + memSeq);

		boolean b = service.makeReadrow(bbsSeq, memSeq);
		if (b == false) {
			return "NO";
		}
		return "YES";
	}

	// 게시글당 조회수
	@GetMapping(value = "partycntRead")
	public int cntRead(int bbsSeq) {
		System.out.println("partyBbsController cntRead : " + new Date());
		System.out.println("cntRead :  bbsSeq: " + bbsSeq);
		return service.cntRead(bbsSeq);
	}
	
	// 메인 
	@GetMapping(value="mainPartypost")
	public List<PartyBbsDto> mainPartypost() {
		System.out.println("partyBbsController mainPartypost : " + new Date());
		return service.mainPartypost();
	}
}
