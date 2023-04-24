package com.woojujumin.dao;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.woojujumin.dto.IdcardDto;
import com.woojujumin.dto.MemberDto;

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

	// 회원수정 4/12
	int changeInfo(MemberDto dto);
	
	// 관리자 페이지 로그인 4/17
	MemberDto adminLogin(MemberDto dto);
	
	// 관리자 등록 4/17
	int adminAddmember(MemberDto dto);
	

	// 관리자 파티장 승급 4/20
	int adminPartyLeader(IdcardDto dto);
	
	// 관리자 파티장 승급 리스트 4/21
	List<IdcardDto> allcheck();
	
	// 관리자 파티장 승급 승인 4/21 
	int partyleadersuccess(String memid);	
	int partyleadercheck(String memid);

	// 카카오 로그인
	MemberDto kakaoLogin(String id);
	
	// 카카오 추가작업
	int kakaoAdd(MemberDto dto);

}
