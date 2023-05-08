package com.woojujumin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import com.woojujumin.dto.BbsCountDto;
import com.woojujumin.dto.ApplyDto;
import com.woojujumin.dto.FreeBbsDto;
import com.woojujumin.dto.PartyBbsDto;
import com.woojujumin.dto.mypartyBbsParam;

@Mapper
@Repository
public interface PartyBbsDao {

	 List<PartyBbsDto> myBbslist(mypartyBbsParam param);

	 int getmyAllBbs(mypartyBbsParam param);

	
	 int writePartybbs(PartyBbsDto dto);
	 
	 PartyBbsDto partyBbsdetail(PartyBbsDto dto);
	 
	 int deletePartybbs(PartyBbsDto dto);
	 
	 List<PartyBbsDto> partybbslist();
	 
	 int updatePartybbs(PartyBbsDto dto);
	 
	 List<PartyBbsDto> getAllpbslist(mypartyBbsParam param);


	int partyApply(ApplyDto dto);
	

	void insertPartyJang(ApplyDto adto);

	PartyBbsDto getSeq(PartyBbsDto dto);

	ApplyDto getCountMem(ApplyDto dto);

	int updateCountMem(ApplyDto dtos);

	List<ApplyDto> getRow(ApplyDto dto);

	List<ApplyDto> getFullRow(ApplyDto dto);

	
}