package com.woojujumin.dto;

import java.io.Serializable;

public class TalkDto implements Serializable {
	
	private int seq;
	private String talkid;
	private String talkcomment;
	private String wdate;
	
	public TalkDto() {
		// TODO Auto-generated constructor stub
	}

	public TalkDto(int seq, String talkid, String talkcomment, String wdate) {
		super();
		this.seq = seq;
		this.talkid = talkid;
		this.talkcomment = talkcomment;
		this.wdate = wdate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTalkid() {
		return talkid;
	}

	public void setTalkid(String talkid) {
		this.talkid = talkid;
	}

	public String getTalkcomment() {
		return talkcomment;
	}

	public void setTalkcomment(String talkcomment) {
		this.talkcomment = talkcomment;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	@Override
	public String toString() {
		return "TalkDto [seq=" + seq + ", talkid=" + talkid + ", talkcomment=" + talkcomment + ", wdate=" + wdate + "]";
	}
	
	
}
