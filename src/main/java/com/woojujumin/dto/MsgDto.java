package com.woojujumin.dto;

import java.io.Serializable;

public class MsgDto implements Serializable {

	private int seq;
	private String targetId;
	private String sendId;
	private String message;
	private String sendDate;
	private int partySeq;
	
	public MsgDto() {
		// TODO Auto-generated constructor stub
	}

	public MsgDto(int seq, String targetId, String sendId, String message, String sendDate, int partySeq) {
		super();
		this.seq = seq;
		this.targetId = targetId;
		this.sendId = sendId;
		this.message = message;
		this.sendDate = sendDate;
		this.partySeq = partySeq;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public String getSendId() {
		return sendId;
	}

	public void setSendId(String sendId) {
		this.sendId = sendId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public int getPartySeq() {
		return partySeq;
	}

	public void setPartySeq(int partySeq) {
		this.partySeq = partySeq;
	}

	@Override
	public String toString() {
		return "MsgDto [seq=" + seq + ", targetId=" + targetId + ", sendId=" + sendId + ", message=" + message
				+ ", sendDate=" + sendDate + ", partySeq=" + partySeq + "]";
	}
}
