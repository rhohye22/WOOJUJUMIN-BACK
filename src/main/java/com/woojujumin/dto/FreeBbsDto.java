package com.woojujumin.dto;

import java.io.Serializable;

public class FreeBbsDto implements Serializable {

	private int bbsSeq;
	private String id;
	private String title;
	private String content;
	private String wdate;
	private int del;
	private int readcount;
	private String image;
	private int tag;
	private int likey;
	private int hate;
	
	public FreeBbsDto() {
		// TODO Auto-generated constructor stub
	}

	public FreeBbsDto(int bbsSeq, String id, String title, String content, String wdate, int del, int readcount,
			String image, int tag, int likey, int hate) {
		super();
		this.bbsSeq = bbsSeq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.wdate = wdate;
		this.del = del;
		this.readcount = readcount;
		this.image = image;
		this.tag = tag;
		this.likey = likey;
		this.hate = hate;
	}

	public int getBbsSeq() {
		return bbsSeq;
	}

	public void setBbsSeq(int bbsSeq) {
		this.bbsSeq = bbsSeq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public int getLikey() {
		return likey;
	}

	public void setLikey(int likey) {
		this.likey = likey;
	}

	public int getHate() {
		return hate;
	}

	public void setHate(int hate) {
		this.hate = hate;
	}

	@Override
	public String toString() {
		return "FreeBbsDto [bbsSeq=" + bbsSeq + ", id=" + id + ", title=" + title + ", content=" + content + ", wdate="
				+ wdate + ", del=" + del + ", readcount=" + readcount + ", image=" + image + ", tag=" + tag + ", likey="
				+ likey + ", hate=" + hate + "]";
	}

}
