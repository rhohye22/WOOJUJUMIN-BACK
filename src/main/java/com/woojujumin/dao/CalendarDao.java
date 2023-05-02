package com.woojujumin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.woojujumin.dto.CalendarDto;

@Mapper
@Repository
public interface CalendarDao {
	
	// 일정 불러오기
	List<CalendarDto> getCalendarList(String yyyymm);
	
	// 일정 작성
	int calwrite(CalendarDto cal);
	
	// 일정 상세보기
	CalendarDto caldetail(int calSeq);
	
	// 일자에 있는 일정 다보기
	List<CalendarDto> getDayList(CalendarDto cal);
	
	// 일정 수정하기
	int calupdate(CalendarDto cal);
	
	// 일정 삭제하기
	int caldelete(int calSeq);
	
	// 일정 검색(Front)
	List<CalendarDto> getDayListFront(String rdate);
}
