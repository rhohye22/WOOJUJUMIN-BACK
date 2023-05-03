package com.woojujumin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woojujumin.dao.AdminDao;
import com.woojujumin.dto.FreeBbsDto;
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
	public List<FreeBbsDto> freebbsSpamlist(){
		return dao.freebbsSpamlist();
	}
	public List<PartyBbsDto> partybbsSpamlist(){
		return dao.partybbsSpamlist();
	}
}
