package com.woojujumin.dto;

public class mypartyBbsParam {
	
	private String choice; 
	private String search;
	private String id;
	private int pageNumber;
	
	private int start; // page 가 1~10이냐 11~20이냐..
	private int end;
	private String title;
	
	public mypartyBbsParam() {
		// TODO Auto-generated constructor stub
	}

	public mypartyBbsParam(String choice, String search, String id, int pageNumber, int start, int end, String title) {
		super();
		this.choice = choice;
		this.search = search;
		this.id = id;
		this.pageNumber = pageNumber;
		this.start = start;
		this.end = end;
		this.title = title;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "mypartyBbsParam [choice=" + choice + ", search=" + search + ", id=" + id + ", pageNumber=" + pageNumber
				+ ", start=" + start + ", end=" + end + ", title=" + title + "]";
	}

	
	
	
	
	

}
