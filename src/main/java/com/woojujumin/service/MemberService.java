package com.woojujumin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woojujumin.dao.MemberDao;

@Service
@Transactional
public class MemberService {
	// test입니다.
	@Autowired
	MemberDao dao;
}
