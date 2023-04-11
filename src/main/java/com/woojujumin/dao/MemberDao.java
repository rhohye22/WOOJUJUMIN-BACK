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
	
	// 회원가입
	int addmember(MemberDto dto);
	
	// 로그인
	MemberDto login(MemberDto dto);
}
