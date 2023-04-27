package com.woojujumin.dto;

import java.io.Serializable;

public class BbsCountDto implements Serializable {

	private String wdate;
	private int count;
	
	public BbsCountDto() {
		// TODO Auto-generated constructor stub
	}

	public BbsCountDto(String wdate, int count) {
		super();
		this.wdate = wdate;
		this.count = count;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "BbsCountDto [wdate=" + wdate + ", count=" + count + "]";
	}

}
