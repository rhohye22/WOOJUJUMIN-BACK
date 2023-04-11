package com.woojujumin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woojujumin.dao.FreeBbsDao;

@Service
@Transactional
public class FreeBbsService {

	@Autowired
	FreeBbsDao dao;
	
}
