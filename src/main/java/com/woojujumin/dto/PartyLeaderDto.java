package com.woojujumin.dto;

import java.io.Serializable;

public class PartyLeaderDto implements Serializable {

	private int seq;
	private String Id;
	private String emailCheck;
	private String wdate;
	private String checkDate;
	
	public PartyLeaderDto() {
		// TODO Auto-generated constructor stub
	}

	public PartyLeaderDto(int seq, String id, String emailCheck, String wdate, String checkDate) {
		super();
		this.seq = seq;
		Id = id;
		this.emailCheck = emailCheck;
		this.wdate = wdate;
		this.checkDate = checkDate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getEmailCheck() {
		return emailCheck;
	}

	public void setEmailCheck(String emailCheck) {
		this.emailCheck = emailCheck;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	@Override
	public String toString() {
		return "PartyLeaderDto [seq=" + seq + ", Id=" + Id + ", emailCheck=" + emailCheck + ", wdate=" + wdate
				+ ", checkDate=" + checkDate + "]";
	}
}
