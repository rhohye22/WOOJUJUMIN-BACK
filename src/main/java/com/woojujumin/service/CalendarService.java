package com.woojujumin.service;

import java.util.List;

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
	
	// 일정 불러오기
	public List<CalendarDto> getCalendarList(String yyyymm){
		return dao.getCalendarList(yyyymm);
	}
	
	// 일정 추가
	public boolean calwrite(CalendarDto cal) {
		int t = dao.calwrite(cal);
		return t>0?true:false;
	}
	
	// 일정 상세보기
	public CalendarDto caldetail(int calSeq) {
		return dao.caldetail(calSeq);
	}
	
	// 일정 보기
	public List<CalendarDto> getDayList(CalendarDto cal){
		return dao.getDayList(cal);
	}
	
	// 일정 수정하기
	public boolean calupdate(CalendarDto cal) {
		int t = dao.calupdate(cal);
		return t>0?true:false;
	}
	
	// 일정 삭제하기
	public boolean caldelete(int calSeq) {
		int t = dao.caldelete(calSeq);
		return t>0?true:false;
	}
}
