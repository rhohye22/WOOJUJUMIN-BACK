package com.woojujumin.dto;

import java.io.Serializable;

public class PartyLikeyDto implements Serializable {

	private int bbsSeq;
	private int memSeq;
	private int likeCheck;
	private int hateCheck;
	
	public PartyLikeyDto() {
		// TODO Auto-generated constructor stub
	}

	public PartyLikeyDto(int bbsSeq, int memSeq, int likeCheck, int hateCheck) {
		super();
		this.bbsSeq = bbsSeq;
		this.memSeq = memSeq;
		this.likeCheck = likeCheck;
		this.hateCheck = hateCheck;
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

	public int getLikeCheck() {
		return likeCheck;
	}

	public void setLikeCheck(int likeCheck) {
		this.likeCheck = likeCheck;
	}

	public int getHateCheck() {
		return hateCheck;
	}

	public void setHateCheck(int hateCheck) {
		this.hateCheck = hateCheck;
	}

	@Override
	public String toString() {
		return "PartyLikeyDto [bbsSeq=" + bbsSeq + ", memSeq=" + memSeq + ", likeCheck=" + likeCheck + ", hateCheck="
				+ hateCheck + "]";
	}
}
