package com.woojujumin.dto;

import java.io.Serializable;

public class ApplyDto implements Serializable {

	private int partySeq;
	private String applyMem;
	private byte check;
	private String wdate; 
	private String title;
	private byte full;
	private String masterId;
	private byte totalMem;
	private byte countMem;
	
	
	public ApplyDto() {
		// TODO Auto-generated constructor stub
	}


	public ApplyDto(int partySeq, String applyMem, byte check, String wdate, String title, byte full, String masterId,
			byte totalMem, byte countMem) {
		super();
		this.partySeq = partySeq;
		this.applyMem = applyMem;
		this.check = check;
		this.wdate = wdate;
		this.title = title;
		this.full = full;
		this.masterId = masterId;
		this.totalMem = totalMem;
		this.countMem = countMem;
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


	public byte getFull() {
		return full;
	}


	public void setFull(byte full) {
		this.full = full;
	}


	public String getMasterId() {
		return masterId;
	}


	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}


	public byte getTotalMem() {
		return totalMem;
	}


	public void setTotalMem(byte totalMem) {
		this.totalMem = totalMem;
	}


	public byte getCountMem() {
		return countMem;
	}


	public void setCountMem(byte countMem) {
		this.countMem = countMem;
	}


	@Override
	public String toString() {
		return "ApplyDto [partySeq=" + partySeq + ", applyMem=" + applyMem + ", check=" + check + ", wdate=" + wdate
				+ ", title=" + title + ", full=" + full + ", masterId=" + masterId + ", totalMem=" + totalMem
				+ ", countMem=" + countMem + "]";
	}


}
