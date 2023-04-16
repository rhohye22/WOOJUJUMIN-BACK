package com.woojujumin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.woojujumin.dto.FreeBbsDto;

@Mapper
@Repository
public interface FreeBbsDao {
	
	List<FreeBbsDto> getAllList();
	
	List<FreeBbsDto> getBbs(int bbsSeq);

}
