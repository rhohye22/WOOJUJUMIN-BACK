package com.woojujumin.dto;

import java.io.Serializable;

public class MemberDto implements Serializable {

	private int memberSeq;
	private String id;
	private String password;
	private String nickname;
	private String email;
	private String phoneNum;
	private String profile;
	private String address;
	private String regdate;
	private byte delflg;
	private byte auth;
	private double point;
	private String masterId;
	private String imageurl;
	
    public MemberDto() {
		
	}

	public MemberDto(int memberSeq, String id, String password, String nickname, String email, String phoneNum,
			String profile, String address, String regdate, byte delflg, byte auth, double point, String masterId,
			String imageurl) {
		super();
		this.memberSeq = memberSeq;
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
		this.phoneNum = phoneNum;
		this.profile = profile;
		this.address = address;
		this.regdate = regdate;
		this.delflg = delflg;
		this.auth = auth;
		this.point = point;
		this.masterId = masterId;
		this.imageurl = imageurl;
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public byte getDelflg() {
		return delflg;
	}

	public void setDelflg(byte delflg) {
		this.delflg = delflg;
	}

	public byte getAuth() {
		return auth;
	}

	public void setAuth(byte auth) {
		this.auth = auth;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	@Override
	public String toString() {
		return "MemberDto [memberSeq=" + memberSeq + ", id=" + id + ", password=" + password + ", nickname=" + nickname
				+ ", email=" + email + ", phoneNum=" + phoneNum + ", profile=" + profile + ", address=" + address
				+ ", regdate=" + regdate + ", delflg=" + delflg + ", auth=" + auth + ", point=" + point + ", masterId="
				+ masterId + ", imageurl=" + imageurl + "]";
	}

}
