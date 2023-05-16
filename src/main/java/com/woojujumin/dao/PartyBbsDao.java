package com.woojujumin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import com.woojujumin.dto.BbsCountDto;
import com.woojujumin.dto.ApplyDto;
import com.woojujumin.dto.FreeBbsDto;
import com.woojujumin.dto.FreeReplyDto;
import com.woojujumin.dto.PartyBbsDto;
import com.woojujumin.dto.PartyReplyDto;
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
	
	//요청인원수
	int applyMemCnt(int partySeq);
	//확정인원수
	int applyCheckMemCnt(int partySeq);
	
	
	//좋아요
	int LikeyPlus(int bbsSeq, int memSeq);
	int LikeyMinus(int bbsSeq, int memSeq);
	int LikeyState(int bbsSeq, int memSeq);
	int cntLikey(int bbsSeq);
	
	//좋아요
	int checkLikeyrow(int bbsSeq, int memSeq);//0이면 없는거 1이면 있는거
	int makeLikeyrow(int bbsSeq, int memSeq);
	
	//댓글
	int writepartyReply(PartyReplyDto dto);
	List<PartyReplyDto> partyReplyList(int replySeq, int start, int limit);
	
	//조회수
	int checkReadrow(int bbsSeq, int memSeq);
	int makeReadrow(int bbsSeq, int memSeq);
	int cntRead(int bbsSeq);
	
	//메인 게시물 뿌려주기 6개 
	List<PartyBbsDto> mainPartypost();
	
}