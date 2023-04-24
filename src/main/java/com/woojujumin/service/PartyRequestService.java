package com.woojujumin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woojujumin.dao.PartyRequestDao;
import com.woojujumin.dto.FreeBbsDto;
import com.woojujumin.dto.mypartyBbsParam;

@Service
@Transactional
public class PartyRequestService {

	@Autowired
	PartyRequestDao dao;

	public List<FreeBbsDto> myRequestList(mypartyBbsParam param) {
		
		return dao.myRequestList(param);
	}

	public int getmyRequestList(mypartyBbsParam param) {
		
		return dao.getmyRequestList(param);
	}
}
