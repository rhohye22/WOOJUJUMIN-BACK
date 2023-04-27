package com.woojujumin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.woojujumin.dto.ApplyDto;
import com.woojujumin.dto.mypartyBbsParam;

@Mapper
@Repository
public interface PartyRequestDao {

	List<mypartyBbsParam> myRequestList(mypartyBbsParam param);

	int getmyRequestList(mypartyBbsParam param);

	List<mypartyBbsParam> myPartyList(mypartyBbsParam param);

	int getmyPartyList(mypartyBbsParam param);

	void updateCheck(ApplyDto dto);

	void updateCount(ApplyDto dto);

	void updatefull(ApplyDto dto);

	List<mypartyBbsParam> partyListmy(mypartyBbsParam param);

	int getpartyListmy(mypartyBbsParam param);



}
