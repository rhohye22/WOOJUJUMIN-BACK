package com.woojujumin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woojujumin.dao.QnaDao;
import com.woojujumin.dto.QnaDto;

@Service
@Transactional
public class QnaService {
	@Autowired
	QnaDao dao;
	
	public List<QnaDto> myqna(String id,int start) {
		return dao.myqna(id,start);
	}
	
	public boolean addQna(QnaDto dto) {
		int cnt = dao.addQna(dto);
		return cnt>0?true:false;
				
	}
	public int cntqna(String id) {
		return dao.cntqna(id);
	}
	public QnaDto getQna(int qnaSeq) {
		return dao.getQna(qnaSeq);
	}
	
	public List<QnaDto> allnewqna(){
		return dao.allnewqna();
	}
	public List<QnaDto> typeqna(String qtype){
		return dao.typeqna(qtype);
	}
	public List<QnaDto> answeredqns(){
		return dao.answeredqns();
	}

	
	
	

}
