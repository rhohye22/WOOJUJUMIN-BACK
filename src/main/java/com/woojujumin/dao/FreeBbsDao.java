package com.woojujumin.dao;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.woojujumin.dto.BbsCountDto;
import com.woojujumin.dto.FreeBbsDto;
import com.woojujumin.dto.FreeReplyDto;

import com.woojujumin.dto.mypartyBbsParam;

@Mapper
@Repository
public interface FreeBbsDao {

	List<FreeBbsDto> myfreeBbslist(mypartyBbsParam param);

	int getmyfreeAllBbs(mypartyBbsParam param);
	
	
	
	//자유게시판(혜원)
	List<FreeBbsDto> freeBbslist(String choice, String search, int start,Integer  tag);
	int cntFreeBbs(String choice, String search,Integer  tag);
	int writeFreeBbs(FreeBbsDto dto);

	FreeBbsDto getfreeBbs(int bbsSeq);
	
	int writeFreeReply(FreeReplyDto dto);
	List<FreeReplyDto> freeReplyList(int replySeq, int start, int limit);
	//좋아요
	int checkLikeyrow(int bbsSeq, int memSeq);//0이면 없는거 1이면 있는거
	int makeLikeyrow(int bbsSeq, int memSeq);
	
	//좋아요
	int LikeyPlus(int bbsSeq, int memSeq);
	int LikeyMinus(int bbsSeq, int memSeq);
	int LikeyState(int bbsSeq, int memSeq);
	int cntLikey(int bbsSeq);
	
	//조회수
	int checkReadrow(int bbsSeq, int memSeq);
	int makeReadrow(int bbsSeq, int memSeq);
	int cntRead(int bbsSeq);

	
	//관리자페이지
	List<BbsCountDto> cntBbsDays();
	List<BbsCountDto> cntRegiMemDays();

}
