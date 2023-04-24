package com.woojujumin.dto;

import java.io.Serializable;

public class CalendarDto implements Serializable {

	private int calSeq;
	private String manager;
	private String title;
	private String content;
	private String rdate;
	private String wdate;
	private int tag;
	private String tagName;
	
	public CalendarDto() {
		// TODO Auto-generated constructor stub
	}

	public CalendarDto(int calSeq, String manager, String title, String content, String rdate, String wdate, int tag) {
		super();
		this.calSeq = calSeq;
		this.manager = manager;
		this.title = title;
		this.content = content;
		this.rdate = rdate;
		this.wdate = wdate;
		this.tag = tag;
		this.tagName = tagName;
	}

	public int getCalSeq() {
		return calSeq;
	}

	public void setCalSeq(int calSeq) {
		this.calSeq = calSeq;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	
	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Override
	public String toString() {
		return "CalendarDto [calSeq=" + calSeq + ", manager=" + manager + ", title=" + title + ", content=" + content
				+ ", rdate=" + rdate + ", wdate=" + wdate + ", tag=" + tag + ", tagName=" + tagName + "]";
	}

	
}
