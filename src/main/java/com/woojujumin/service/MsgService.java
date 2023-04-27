package com.woojujumin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woojujumin.dao.MsgDao;
import com.woojujumin.dto.ApplyDto;
import com.woojujumin.dto.FreeBbsDto;
import com.woojujumin.dto.MemberDto;
import com.woojujumin.dto.MsgDto;
import com.woojujumin.dto.mypartyBbsParam;


@Service
@Transactional
public class MsgService {
	
	@Autowired
	MsgDao dao;

	public List<MemberDto> allmember(ApplyDto dto) {
		
		return dao.allmember(dto);
	}

	
	// 메시지 전송(insert)
	public boolean msgWrite(MsgDto dto) {
		
		int n = dao.msgWrite(dto);
		
		return n>0?true:false;
	}

////////////////////////////// 받은 메시지 보기 ///////////////////////////////////////
	public List<FreeBbsDto> msglist(mypartyBbsParam param) {
		
		return dao.msglist(param);
	}


	public int getmsglist(mypartyBbsParam param) {
		
		return dao.getmsglist(param);
	}
////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////보낸 메시지 보기/////////////////////////////////////////////

	public List<FreeBbsDto> sendmsglist(mypartyBbsParam param) {
		
		return dao.sendmsglist(param);
	}


	public int getsendmsglist(mypartyBbsParam param) {
		
		return dao.getsendmsglist(param);
	}
////////////////////////////////////////////////////////////////////////////////

//메시지 삭제
	public boolean delMsg(MsgDto dto) {
		
		int n = dao.delMsg(dto);
		
		return n>0?true:false;
	}


	
}
