package com.woojujumin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.woojujumin.dto.PartyBbsDto;
import com.woojujumin.dto.mypartyBbsParam;

@Mapper
@Repository
public interface PartyBbsDao {

	 List<PartyBbsDto> myBbslist(mypartyBbsParam param);

	 int getmyAllBbs(mypartyBbsParam param);
	

}
