package com.woojujumin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woojujumin.dao.PartyRequestDao;
import com.woojujumin.dto.ApplyDto;
import com.woojujumin.dto.mypartyBbsParam;

@Service
@Transactional
public class PartyRequestService {

	@Autowired
	PartyRequestDao dao;

	public List<mypartyBbsParam> myRequestList(mypartyBbsParam param) {
		
		return dao.myRequestList(param);
	}

	public int getmyRequestList(mypartyBbsParam param) {
		
		return dao.getmyRequestList(param);
	}

	public List<mypartyBbsParam> myPartyList(mypartyBbsParam param) {
		
		return dao.myPartyList(param);
	}

	public int getmyPartyList(mypartyBbsParam param) {
		
		return dao.getmyPartyList(param);
		
	}

	public void updateCheck(ApplyDto dto) {
		
		dao.updateCheck(dto);
	}

	public void updateCount(ApplyDto dto) {
		
		dao.updateCount(dto);
	}

	public void updatefull(ApplyDto dto) {
		
		dao.updatefull(dto);
		
	}

	public List<mypartyBbsParam> partyListmy(mypartyBbsParam param) {
		
		return dao.partyListmy(param);
	}

	public int getpartyListmy(mypartyBbsParam param) {
		
		return dao.getpartyListmy(param);
	}


}
