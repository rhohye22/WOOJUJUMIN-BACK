package com.woojujumin.dao;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.woojujumin.dto.FreeBbsDto;

import com.woojujumin.dto.mypartyBbsParam;

@Mapper
@Repository
public interface FreeBbsDao {

	List<FreeBbsDto> myfreeBbslist(mypartyBbsParam param);

	int getmyfreeAllBbs(mypartyBbsParam param);


	
	List<FreeBbsDto> getAllList();
	
	List<FreeBbsDto> getBbs(int bbsSeq);


}
