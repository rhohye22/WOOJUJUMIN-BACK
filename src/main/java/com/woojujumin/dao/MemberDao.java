package com.woojujumin.dao;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
	
	// 카카오 로그인
	MemberDto kakaoLogin(String id);
	
	// 카카오 추가작업
	int kakaoAdd(MemberDto dto);
}
