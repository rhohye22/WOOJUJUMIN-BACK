package com.woojujumin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woojujumin.dao.PartyBbsDao;
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




}
