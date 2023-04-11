package com.woojujumin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woojujumin.dao.PartyBbsDao;

@Service
@Transactional
public class PartyBbsService {
	
	@Autowired
	PartyBbsDao dao;
}
