package com.woojujumin.dao;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.woojujumin.dto.IdcardDto;
import com.woojujumin.dto.MemberDto;
import com.woojujumin.dto.TalkDto;

@Mapper
@Repository
public interface MemberDao {

	List<MemberDto> allmember();
	
	// 아이디 체크
	int idcheck(String id);
	
	// 닉네임 체크
	int nickcheck(String nickname);
	
	// 회원가입
	int addmember(MemberDto dto);
	
	// 로그인
	MemberDto login(MemberDto dto);
	
	// 아이디 찾기
	MemberDto idsearch(String email);
	
	// 임시 비밀번호 발급
	int pwdsearch(MemberDto dto);

	// 회원수정 4/12
	int changeInfo(MemberDto dto);
	
	// 관리자 페이지 로그인 4/17
	MemberDto adminLogin(MemberDto dto);
	
	// 관리자 등록 4/17
	int adminAddmember(MemberDto dto);
	
	// 소셜 로그인
	MemberDto socialLogin(String id);
	
	// 소셜 추가작업
	int socialAdd(MemberDto dto);

	// 관리자 파티장 승급 4/20
	int adminPartyLeader(IdcardDto dto);
	
	// 관리자 파티장 승급 리스트 4/21
	List<IdcardDto> allcheck();
	
	// 관리자 파티장 승급 승인 4/21 
	int partyleadersuccess(String memid);	
	int partyleadercheck(String memid);
	
	// 크롤링사이트 댓글쓰기
	int talkcomment(TalkDto talk);
	
	// 크롤링사이트 댓글보기
	List<TalkDto> alltalkcomment(TalkDto talk);
}
