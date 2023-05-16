package com.woojujumin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woojujumin.dao.PartyBbsDao;
import com.woojujumin.dto.BbsCountDto;
import com.woojujumin.dto.ApplyDto;
import com.woojujumin.dto.FreeBbsDto;
import com.woojujumin.dto.FreeReplyDto;
import com.woojujumin.dto.PartyBbsDto;
import com.woojujumin.dto.PartyReplyDto;
import com.woojujumin.dto.mypartyBbsParam;

@Service
@Transactional
public class PartyBbsService {

	@Autowired
	PartyBbsDao dao;

	public List<PartyBbsDto> myBbslist(mypartyBbsParam param) {

		return dao.myBbslist(param);
	}

	public int getmyAllBbs(mypartyBbsParam param) {

		return dao.getmyAllBbs(param);
	}

	public boolean writePartybbs(PartyBbsDto dto) {
		int cnt = dao.writePartybbs(dto);

		return cnt > 0 ? true : false;
	}

	public PartyBbsDto partyBbsdetail(PartyBbsDto dto) {

		return dao.partyBbsdetail(dto);
	}

	public boolean deletePartybbs(PartyBbsDto dto) {
		int cnt = dao.deletePartybbs(dto);

		return cnt > 0 ? true : false;
	}

	public List<PartyBbsDto> partybbslist() {

		return dao.partybbslist();
	}

	public boolean updatePartybbs(PartyBbsDto dto) {
		int cnt = dao.updatePartybbs(dto);

		return cnt > 0 ? true : false;
	}

	public List<PartyBbsDto> getAllpbslist(mypartyBbsParam param) {

		return dao.getAllpbslist(param);
	}

	public boolean partyApply(ApplyDto dto) {

		int cnt = dao.partyApply(dto);

		return cnt > 0 ? true : false;
	}

	public void insertPartyJang(ApplyDto adto) {

		dao.insertPartyJang(adto);
	}

	public PartyBbsDto getSeq(PartyBbsDto dto) {

		return dao.getSeq(dto);
	}

	public ApplyDto getCountMem(ApplyDto dto) {

		return dao.getCountMem(dto);
	}

	public boolean updateCountMem(ApplyDto dtos) {

		int cnt = dao.updateCountMem(dtos);

		return cnt > 0 ? true : false;
	}

	public List<ApplyDto> getRow(ApplyDto dto) {

		return dao.getRow(dto);
	}

	public List<ApplyDto> getFullRow(ApplyDto dto) {

		return dao.getFullRow(dto);
	}

	public int applyMemCnt(int partySeq) {

		return dao.applyMemCnt(partySeq);
	}

	public int applyCheckMemCnt(int partySeq) {

		return dao.applyCheckMemCnt(partySeq);
	}

	// 좋아요
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

	
	// 댓글
	public boolean writepartyReply(PartyReplyDto dto) {
		int cnt = dao.writepartyReply(dto);
		return cnt > 0 ? true : false;
	}

	public List<PartyReplyDto> partyReplyList(int replySeq, int start, int limit) {
		return dao.partyReplyList(replySeq, start, limit);
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
		
	// 메인 게시글뿌려주기 
	public List<PartyBbsDto> mainPartypost() {
		return dao.mainPartypost();
	}
	
}
