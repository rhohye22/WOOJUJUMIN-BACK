package com.woojujumin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.woojujumin.dto.BbsCountDto;
import com.woojujumin.dto.FreeBbsDto;
import com.woojujumin.dto.FreeReplyDto;
import com.woojujumin.dto.MemberDto;
import com.woojujumin.dto.PartyBbsDto;
import com.woojujumin.dto.PartyReplyDto;
import com.woojujumin.dto.SpamWordDto;

@Mapper
@Repository
public interface AdminDao {

	List<SpamWordDto> allSpamWord();
	
	int addSpamword(String word);
	int deleteSpamword(String word);
	
	List<FreeBbsDto> freebbsSpamlist();
	List<PartyBbsDto> partybbsSpamlist();
	
	List<PartyBbsDto> PartyBbslistAdmin(String choice, String search, int start,Integer  tag);
	int cntPartyBbsAdmin(String choice, String search,Integer  tag);
	PartyBbsDto getPartyBbsAdmin(int partySeq);
	 
	int delFreebbsByAdmin(int bbsSeq);
	int reopenFreebbsByAdmin(int bbsSeq);
	int delPartybbsByAdmin(int partySeq);
	int reopenPartybbsByAdmin(int partySeq);
	
	List<MemberDto> getMemlistByAuth(int auth);
	
	MemberDto getMemeberInfo(int memberSeq);
	
	int stateControl(int auth, int memberSeq);
	
	 
	 
	 List<BbsCountDto> cntFbsDays();
	 
	 List<FreeReplyDto> freeBbsSpamReply();
	 List<PartyReplyDto> partyBbsSpamReply();
	 List<PartyReplyDto> partyReplyListAdmin(int replySeq, int start, int limit);
	 
	 int stateFreeReplyControl( int seq,int replySeq, int del);
	 int statePartyReplyControl( int seq,int replySeq, int del);
	 
 }
