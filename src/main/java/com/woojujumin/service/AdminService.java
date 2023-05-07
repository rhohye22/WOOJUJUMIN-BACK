package com.woojujumin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woojujumin.dao.AdminDao;
import com.woojujumin.dto.BbsCountDto;
import com.woojujumin.dto.FreeBbsDto;
import com.woojujumin.dto.FreeReplyDto;
import com.woojujumin.dto.MemberDto;
import com.woojujumin.dto.PartyBbsDto;
import com.woojujumin.dto.SpamWordDto;

@Service
@Transactional
public class AdminService {
	@Autowired
	AdminDao dao;

	public List<SpamWordDto> allSpamWord() {
		return dao.allSpamWord();
	}

	public boolean addSpamword(String word) {
		int cnt = dao.addSpamword(word);
		return cnt > 0 ? true : false;
	}

	public boolean deleteSpamword(String word) {
		int cnt = dao.deleteSpamword(word);
		return cnt > 0 ? true : false;
	}

	public List<FreeBbsDto> freebbsSpamlist() {
		return dao.freebbsSpamlist();
	}

	public List<PartyBbsDto> partybbsSpamlist() {
		return dao.partybbsSpamlist();
	}

	public List<PartyBbsDto> PartyBbslistAdmin(String choice, String search, int start, Integer tag) {
		return dao.PartyBbslistAdmin(choice, search, start, tag);
	}

	public int cntPartyBbsAdmin(String choice, String search, Integer tag) {
		return dao.cntPartyBbsAdmin(choice, search, tag);

	}

	public PartyBbsDto getPartyBbsAdmin(int partySeq) {
		return dao.getPartyBbsAdmin(partySeq);
	}
	public boolean delFreebbsByAdmin(int bbsSeq) {
		int cnt = dao.delFreebbsByAdmin(bbsSeq);
		return cnt > 0 ? true : false;
	}
	public boolean reopenFreebbsByAdmin(int bbsSeq) {
		int cnt = dao.reopenFreebbsByAdmin(bbsSeq);
		return cnt > 0 ? true : false;
	}
	public boolean delPartybbsByAdmin(int partySeq) {
		int cnt = dao.delPartybbsByAdmin(partySeq);
		return cnt > 0 ? true : false;
	}
	public boolean reopenPartybbsByAdmin(int partySeq) {
		int cnt = dao.reopenPartybbsByAdmin(partySeq);
		return cnt > 0 ? true : false;
	}
	
	public List<MemberDto> getMemlistByAuth(int auth){
		return dao.getMemlistByAuth(auth);
	}
	public MemberDto getMemeberInfo(int memberSeq){
		return dao.getMemeberInfo(memberSeq);
	}
	public boolean  stateControl(int auth, int memberSeq) {
		int cnt = dao.stateControl(auth, memberSeq);
		return cnt > 0 ? true : false;
	}
	//관리자 페이지
	public List<BbsCountDto> cntFbsDays(){
		return dao.cntFbsDays();
	}
	
}
