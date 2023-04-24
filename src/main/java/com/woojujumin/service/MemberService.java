package com.woojujumin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woojujumin.dao.MemberDao;
import com.woojujumin.dto.IdcardDto;
import com.woojujumin.dto.MemberDto;

@Service
@Transactional
public class MemberService {
	// test입니다.
	@Autowired
	MemberDao dao;
	
	public List<MemberDto> allmember() {
		return dao.allmember();
	}
	
	// 아이디 체크
	public boolean idcheck(String id) {
		int n = dao.idcheck(id);
		return n>0?true:false;
	}
	
	// 닉네임 체크
	public boolean nickcheck(String nickname) {
		int n = dao.nickcheck(nickname);
		return n>0?true:false;
	}
	
	// 회원가입
	public boolean addmember(MemberDto dto) {
		int n = dao.addmember(dto);
		return n>0?true:false;
	}
	
	// 로그인
	public MemberDto login(MemberDto dto) {
		return dao.login(dto);
	}

	// 회원수정 4/12
	public boolean changeInfo(MemberDto dto) {
		int n = dao.changeInfo(dto);
		return n>0?true:false;
	}
	
	//관리자 페이지 로그인 4/17
	public MemberDto adminLogin(MemberDto dto) {
		return dao.adminLogin(dto);
	}
	 
	//관리자 등록 4/17
	public boolean adminAddmember(MemberDto dto) {
		int n = dao.adminAddmember(dto);
		return n>0?true:false; 
	}
	

	// 관리자 파티장 승급 4/20
	public boolean adminPartyLeader(IdcardDto dto) {
		int n = dao.adminPartyLeader(dto);
		return n>0?true:false;
	}
	
	// 관리자 파티장 승급 4/21
	public List<IdcardDto> allcheck(){
		return dao.allcheck();
	}
	
	// 관리자 파티장 승급 4/21
	public boolean partyleadersuccess(String memid) {
		int t = dao.partyleadersuccess(memid);
		int n = dao.partyleadercheck(memid);
		return t>0 && n>0?true:false;

	// 카카오 로그인
	public MemberDto kakaoLogin(String id) {
		return dao.kakaoLogin(id);
	}
	
	// 카카오 추가작업
	public boolean kakaoAdd(MemberDto dto) {
		int n = dao.kakaoAdd(dto);
		return n>0?true:false;

	}
}
