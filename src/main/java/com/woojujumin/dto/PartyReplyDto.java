package com.woojujumin.dto;

import java.io.Serializable;

public class PartyReplyDto implements Serializable {

	private int seq;
	private int replySeq;
	private String content;
	private String writer;
	private String wdate;
	private int del;
	
	public PartyReplyDto() {
		// TODO Auto-generated constructor stub
	}

	public PartyReplyDto(int seq, int replySeq, String content, String writer, String wdate, int del) {
		super();
		this.seq = seq;
		this.replySeq = replySeq;
		this.content = content;
		this.writer = writer;
		this.wdate = wdate;
		this.del = del;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getReplySeq() {
		return replySeq;
	}

	public void setReplySeq(int replySeq) {
		this.replySeq = replySeq;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	@Override
	public String toString() {
		return "PartyReplyDto [seq=" + seq + ", replySeq=" + replySeq + ", content=" + content + ", writer=" + writer
				+ ", wdate=" + wdate + ", del=" + del + "]";
	}

	
}
