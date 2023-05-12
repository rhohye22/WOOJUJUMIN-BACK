package com.woojujumin.dto;

import java.io.Serializable;

public class IdcardDto implements Serializable {

	private int seq;
	private String memid;
	private String idname;
	private String idbirth;
	private String idaddress;
	private String iddate;
	private String idpublic;
	private String idimage;
	private String wdate;
	private String cardcheck;
	private String checkdate;
	
	public IdcardDto() {
	}

	public IdcardDto(int seq, String memid, String idname, String idbirth, String idaddress, String iddate,
			String idpublic, String idimage, String wdate, String cardcheck, String checkdate) {
		super();
		this.seq = seq;
		this.memid = memid;
		this.idname = idname;
		this.idbirth = idbirth;
		this.idaddress = idaddress;
		this.iddate = iddate;
		this.idpublic = idpublic;
		this.idimage = idimage;
		this.wdate = wdate;
		this.cardcheck = cardcheck;
		this.checkdate = checkdate;
	}



	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getMemid() {
		return memid;
	}

	public void setMemid(String memid) {
		this.memid = memid;
	}

	public String getIdname() {
		return idname;
	}

	public void setIdname(String idname) {
		this.idname = idname;
	}

	public String getIdbirth() {
		return idbirth;
	}

	public void setIdbirth(String idbirth) {
		this.idbirth = idbirth;
	}

	public String getIdaddress() {
		return idaddress;
	}

	public void setIdaddress(String idaddress) {
		this.idaddress = idaddress;
	}

	public String getIddate() {
		return iddate;
	}

	public void setIddate(String iddate) {
		this.iddate = iddate;
	}

	public String getIdpublic() {
		return idpublic;
	}

	public void setIdpublic(String idpublic) {
		this.idpublic = idpublic;
	}

	public String getIdimage() {
		return idimage;
	}

	public void setIdimage(String idimage) {
		this.idimage = idimage;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public String getCardcheck() {
		return cardcheck;
	}

	public void setCardcheck(String cardcheck) {
		this.cardcheck = cardcheck;
	}

	public String getCheckdate() {
		return checkdate;
	}

	public void setCheckdate(String checkdate) {
		this.checkdate = checkdate;
	}

	@Override
	public String toString() {
		return "IdcardDto [seq=" + seq + ", memid=" + memid + ", idname=" + idname + ", idbirth=" + idbirth
				+ ", idaddress=" + idaddress + ", iddate=" + iddate + ", idpublic=" + idpublic + ", idimage=" + idimage
				+ ", wdate=" + wdate + ", cardcheck=" + cardcheck + ", checkdate=" + checkdate + "]";
	}

	
}
