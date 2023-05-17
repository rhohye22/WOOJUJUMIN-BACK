package com.woojujumin.dto;

import java.io.Serializable;

public class PartyBbsDto implements Serializable {

	private int partySeq; // 이거
	private String id;// 이거
   private String title;
   private String content;
   private String image;
   private String wdate;// 이거
   private int del;
   private int readcount;
   private int tag;
   private int partytype;
   private int people; // 이거
   private int likey;
   private int hate;
   private String place;
   private String mdate;
   private int applymem;
   private int endparty;
   private int fullparty;
   private String imageurl;
   
   
   public PartyBbsDto() {
	// TODO Auto-generated constructor stub
   }

	public PartyBbsDto(int partySeq, String id, String title, String content, String image, String wdate, int del,
			int readcount, int tag, int partytype, int people, int likey, int hate, String place, String mdate,
			int applymem, int endparty, int fullparty, String imageurl) {
		super();
		this.partySeq = partySeq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.image = image;
		this.wdate = wdate;
		this.del = del;
		this.readcount = readcount;
		this.tag = tag;
		this.partytype = partytype;
		this.people = people;
		this.likey = likey;
		this.hate = hate;
		this.place = place;
		this.mdate = mdate;
		this.applymem = applymem;
		this.endparty = endparty;
		this.fullparty = fullparty;
		this.imageurl = imageurl;
	}

	public int getPartySeq() {
		return partySeq;
	}

	public void setPartySeq(int partySeq) {
		this.partySeq = partySeq;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public int getPartytype() {
		return partytype;
	}

	public void setPartytype(int partytype) {
		this.partytype = partytype;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
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

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	public int getApplymem() {
		return applymem;
	}

	public void setApplymem(int applymem) {
		this.applymem = applymem;
	}

	public int getEndparty() {
		return endparty;
	}

	public void setEndparty(int endparty) {
		this.endparty = endparty;
	}

	public int getFullparty() {
		return fullparty;
	}

	public void setFullparty(int fullparty) {
		this.fullparty = fullparty;
	}
	
	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	@Override
	public String toString() {
		return "PartyBbsDto [partySeq=" + partySeq + ", id=" + id + ", title=" + title + ", content=" + content
				+ ", image=" + image + ", wdate=" + wdate + ", del=" + del + ", readcount=" + readcount + ", tag=" + tag
				+ ", partytype=" + partytype + ", people=" + people + ", likey=" + likey + ", hate=" + hate + ", place="
				+ place + ", mdate=" + mdate + ", applymem=" + applymem + ", endparty=" + endparty + ", fullparty="
				+ fullparty + ", imageurl=" + imageurl + "]";
	}

	
}
