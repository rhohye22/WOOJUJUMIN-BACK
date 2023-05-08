package com.woojujumin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woojujumin.dao.FreeBbsDao;
import com.woojujumin.dto.BbsCountDto;
import com.woojujumin.dto.FreeBbsDto;
import com.woojujumin.dto.FreeReplyDto;
import com.woojujumin.dto.mypartyBbsParam;

@Service
@Transactional
public class FreeBbsService {

	@Autowired
	FreeBbsDao dao;

	public List<FreeBbsDto> myfreeBbslist(mypartyBbsParam param) {

		return dao.myfreeBbslist(param);
	}

	public int getmyfreeAllBbs(mypartyBbsParam param) {

		return dao.getmyfreeAllBbs(param);
	}

	// 자유게시판(혜원)

	public List<FreeBbsDto> freeBbslist(String choice, String search, int start, Integer tag) {
		return dao.freeBbslist(choice, search, start, tag);
	}

	public int cntFreeBbs(String choice, String search, Integer tag) {
		return dao.cntFreeBbs(choice, search, tag);
	}

	public boolean writeFreeBbs(FreeBbsDto dto) {
		int cnt = dao.writeFreeBbs(dto);
		return cnt > 0 ? true : false;

	}
	public boolean modifyFreebbs(FreeBbsDto dto) {
		int cnt = dao.modifyFreebbs(dto);
		return cnt > 0 ? true : false;
		
	}
	public boolean delFeebbsByWriter(int bbsSeq) {
		int cnt = dao.delFeebbsByWriter(bbsSeq);
		return cnt > 0 ? true : false;
		
	}

	public FreeBbsDto getfreeBbs(int bbsSeq) {
		return dao.getfreeBbs(bbsSeq);
	}

	
	// 댓글
	public boolean writeFreeReply(FreeReplyDto dto) {
		int cnt = dao.writeFreeReply(dto);
		return cnt > 0 ? true : false;
	}

	public List<FreeReplyDto> freeReplyList(int replySeq, int start, int limit) {
		return dao.freeReplyList(replySeq, start, limit);
	}

	
	
	//좋아요
	public int checkLikeyrow(int bbsSeq, int memSeq) {
		return dao.checkLikeyrow(bbsSeq, memSeq);
	}

	public boolean makeLikeyrow(int bbsSeq, int memSeq) {
		int cnt = dao.makeLikeyrow(bbsSeq, memSeq);
		return cnt > 0 ? true : false;

	}

	public boolean LikeyPlus(int bbsSeq, int memSeq) {
		int cnt = dao.LikeyPlus(bbsSeq, memSeq);
		return cnt > 0 ? true : false;

	}

	public boolean LikeyMinus(int bbsSeq, int memSeq) {
		int cnt = dao.LikeyMinus(bbsSeq, memSeq);
		return cnt > 0 ? true : false;

	}

	public int LikeyState(int bbsSeq, int memSeq) {
		return dao.LikeyState(bbsSeq, memSeq);
	}

	public int cntLikey(int bbsSeq) {
		return dao.cntLikey(bbsSeq);
	}
	
	//조회수
	

	public int checkReadrow(int bbsSeq, int memSeq) {
		return dao.checkReadrow(bbsSeq, memSeq);
	}

	public boolean makeReadrow(int bbsSeq, int memSeq) {
		int cnt = dao.makeReadrow(bbsSeq, memSeq);
		return cnt > 0 ? true : false;

	}
	
	public int cntRead(int bbsSeq) {
		return dao.cntRead(bbsSeq);
	}
	
	//관리자 페이지
	public List<BbsCountDto> cntBbsDays(){
		return dao.cntBbsDays();
	}
	public List<BbsCountDto> cntRegiMemDays(){
		return dao.cntRegiMemDays();
	}
	

}
