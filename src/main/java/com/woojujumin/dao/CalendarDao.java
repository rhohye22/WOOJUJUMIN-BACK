package com.woojujumin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.woojujumin.dto.CalendarDto;

@Mapper
@Repository
public interface CalendarDao {

	int calwrite(CalendarDto cal);
}
