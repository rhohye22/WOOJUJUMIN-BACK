package com.woojujumin.dto;

public class PartyReadDto {
	private int bbsSeq;
	private int memSeq;
	
	public PartyReadDto() {
		// TODO Auto-generated constructor stub
	}
	
	public PartyReadDto(int bbsSeq, int memSeq) {
		super();
		this.bbsSeq = bbsSeq;
		this.memSeq = memSeq;
	}
	public int getBbsSeq() {
		return bbsSeq;
	}
	public void setBbsSeq(int bbsSeq) {
		this.bbsSeq = bbsSeq;
	}
	public int getMemSeq() {
		return memSeq;
	}
	public void setMemSeq(int memSeq) {
		this.memSeq = memSeq;
	}

	@Override
	public String toString() {
		return "PartyReadDto [bbsSeq=" + bbsSeq + ", memSeq=" + memSeq + "]";
	}
	
	
	
}
