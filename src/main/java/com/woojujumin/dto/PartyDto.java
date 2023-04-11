package com.woojujumin.dto;

import java.io.Serializable;

public class PartyDto implements Serializable {

	private int tagSeq;
	private String tagName;
	
	public PartyDto() {
		// TODO Auto-generated constructor stub
	}

	public PartyDto(int tagSeq, String tagName) {
		super();
		this.tagSeq = tagSeq;
		this.tagName = tagName;
	}

	public int getTagSeq() {
		return tagSeq;
	}

	public void setTagSeq(int tagSeq) {
		this.tagSeq = tagSeq;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Override
	public String toString() {
		return "PartyDto [tagSeq=" + tagSeq + ", tagName=" + tagName + "]";
	}
}
