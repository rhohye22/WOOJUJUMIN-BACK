package com.woojujumin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woojujumin.dao.PartyBbsDao;
import com.woojujumin.dto.BbsCountDto;
import com.woojujumin.dto.FreeBbsDto;
import com.woojujumin.dto.PartyBbsDto;
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
		
		return cnt>0?true:false;
	}
	
	public PartyBbsDto partyBbsdetail(PartyBbsDto dto) {
		
		return dao.partyBbsdetail(dto);
	}
	
	public boolean deletePartybbs(PartyBbsDto dto) {
		int cnt = dao.deletePartybbs(dto);
		
		return cnt>0?true:false;
	}  
	
	public List<PartyBbsDto> partybbslist() {
		
		return dao.partybbslist();
	}
	
	public boolean updatePartybbs(PartyBbsDto dto) {
		int cnt = dao.updatePartybbs(dto);
		
		return cnt>0?true:false;
	}
	
	public List<PartyBbsDto> getAllpbslist (mypartyBbsParam param){
		
		return dao.getAllpbslist(param);
	}

}
