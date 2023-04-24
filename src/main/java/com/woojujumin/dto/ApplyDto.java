package com.woojujumin.dto;

import java.io.Serializable;

public class ApplyDto implements Serializable {

	private int partySeq;
	private String applyMem;
	private byte check;
	private String wdate; 
	private String title;
	
	public ApplyDto() {
		// TODO Auto-generated constructor stub
	}

	public ApplyDto(int partySeq, String applyMem, byte check, String wdate, String title) {
		super();
		this.partySeq = partySeq;
		this.applyMem = applyMem;
		this.check = check;
		this.wdate = wdate;
		this.title = title;
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

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "ApplyDto [partySeq=" + partySeq + ", applyMem=" + applyMem + ", check=" + check + ", wdate=" + wdate
				+ ", title=" + title + "]";
	}

	
	
	
}
