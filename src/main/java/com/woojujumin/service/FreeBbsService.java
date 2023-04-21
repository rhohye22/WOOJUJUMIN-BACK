package com.woojujumin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woojujumin.dao.FreeBbsDao;
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

	public List<FreeBbsDto> freeBbslist(String choice, String search, int start) {
		return dao.freeBbslist(choice, search, start);
	}

	public int cntFreeBbs(String choice, String search) {
		return dao.cntFreeBbs(choice, search);
	}

	public boolean writeFreeBbs(FreeBbsDto dto) {
		int cnt = dao.writeFreeBbs(dto);
		return cnt > 0 ? true : false;

	}
	public boolean writeFreeReply(FreeReplyDto dto) {
		int cnt = dao.writeFreeReply(dto);
		return cnt > 0 ? true : false;
		
	}

	public FreeBbsDto getfreeBbs(int bbsSeq) {
		return dao.getfreeBbs(bbsSeq);
	}

	public List<FreeReplyDto> freeReplyList(int replySeq, int start, int limit){
		return dao.freeReplyList(replySeq,start,limit);
	}
	
//쓰는지 확인필요
	public List<FreeBbsDto> getAllList() {
		return dao.getAllList();
	}

}
