package com.woojujumin.dao;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.woojujumin.dto.FreeBbsDto;
import com.woojujumin.dto.FreeReplyDto;

import com.woojujumin.dto.mypartyBbsParam;

@Mapper
@Repository
public interface FreeBbsDao {

	List<FreeBbsDto> myfreeBbslist(mypartyBbsParam param);

	int getmyfreeAllBbs(mypartyBbsParam param);
	
	
	
	
	//자유게시판(혜원)
	List<FreeBbsDto> freeBbslist(String choice, String search, int start);
	int cntFreeBbs(String choice, String search);
	int writeFreeBbs(FreeBbsDto dto);

	FreeBbsDto getfreeBbs(int bbsSeq);
	
	int writeFreeReply(FreeReplyDto dto);
	List<FreeReplyDto> freeReplyList(int replySeq, int start, int limit);
	
	
	
	// 쓰는지 안쓰는지 확인필요
	
	List<FreeBbsDto> getAllList();
	
	

}
