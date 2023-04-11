package com.woojujumin.dto;

import java.io.Serializable;

public class CategoryDto implements Serializable {

	private int tagSeq;
	private String tagName;
	
	public CategoryDto() {
		// TODO Auto-generated constructor stub
	}

	public CategoryDto(int tagSeq, String tagName) {
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
		return "CategoryDto [tagSeq=" + tagSeq + ", tagName=" + tagName + "]";
	}
}
