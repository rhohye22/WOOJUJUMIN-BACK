package com.woojujumin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.woojujumin.dto.FreeBbsDto;
import com.woojujumin.dto.PartyBbsDto;
import com.woojujumin.dto.SpamWordDto;

@Mapper
@Repository
public interface AdminDao {

	List<SpamWordDto> allSpamWord();
	
	int addSpamword(String word);
	int deleteSpamword(String word);
	
	List<FreeBbsDto> freebbsSpamlist();
	List<PartyBbsDto> partybbsSpamlist();
 }
