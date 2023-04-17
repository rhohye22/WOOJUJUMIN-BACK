package com.woojujumin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woojujumin.dao.CalendarDao;
import com.woojujumin.dto.CalendarDto;

@Service
@Transactional
public class CalendarService {
	
	@Autowired
	CalendarDao dao;
	
	public boolean calwrite(CalendarDto cal) {
		int t = dao.calwrite(cal);
		return t>0?true:false;
	}
}
