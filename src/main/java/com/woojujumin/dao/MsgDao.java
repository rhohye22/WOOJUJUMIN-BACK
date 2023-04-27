package com.woojujumin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.woojujumin.dto.ApplyDto;
import com.woojujumin.dto.FreeBbsDto;
import com.woojujumin.dto.MemberDto;
import com.woojujumin.dto.MsgDto;
import com.woojujumin.dto.mypartyBbsParam;

@Mapper
@Repository
public interface MsgDao {

	List<MemberDto> allmember(ApplyDto dto);

	int msgWrite(MsgDto dto);

	List<FreeBbsDto> msglist(mypartyBbsParam param); // 받은 메시지 보기

	int getmsglist(mypartyBbsParam param);// 받은 메시지 보기

	List<FreeBbsDto> sendmsglist(mypartyBbsParam param); // 보낸 메시지 보기

	int getsendmsglist(mypartyBbsParam param);// 보낸 메시지 보기

	int delMsg(MsgDto dto);



	
}
