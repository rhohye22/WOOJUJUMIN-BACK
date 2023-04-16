package com.woojujumin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woojujumin.dao.FreeBbsDao;
import com.woojujumin.dto.FreeBbsDto;

@Service
@Transactional
public class FreeBbsService {

	@Autowired
	FreeBbsDao dao;
	
	public List<FreeBbsDto> getAllList() {
		return dao.getAllList();
	}
	
	public List<FreeBbsDto> getBbs(int bbsSeq) {
		return dao.getBbs(bbsSeq);
	}
	
}
