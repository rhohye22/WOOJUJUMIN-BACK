package com.woojujumin.dto;

import java.io.Serializable;

public class ApplyDto implements Serializable {

	private int partySeq;
	private String applyMem;
	private byte check;
	
	public ApplyDto() {
		// TODO Auto-generated constructor stub
	}

	public ApplyDto(int partySeq, String applyMem, byte check) {
		super();
		this.partySeq = partySeq;
		this.applyMem = applyMem;
		this.check = check;
	}

	public int getPartySeq() {
		return partySeq;
	}

	public void setPartySeq(int partySeq) {
		this.partySeq = partySeq;
	}

	public String getApplyMem() {
		return applyMem;
	}

	public void setApplyMem(String applyMem) {
		this.applyMem = applyMem;
	}

	public byte getCheck() {
		return check;
	}

	public void setCheck(byte check) {
		this.check = check;
	}

	@Override
	public String toString() {
		return "ApplyDto [partySeq=" + partySeq + ", applyMem=" + applyMem + ", check=" + check + "]";
	}
}
