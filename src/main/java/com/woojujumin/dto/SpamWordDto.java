package com.woojujumin.dto;

import java.io.Serializable;

public class SpamWordDto implements Serializable {
 private int spamSeq;
 private String word;
 public SpamWordDto() {
	// TODO Auto-generated constructor stub
}
public SpamWordDto(int spamSeq, String word) {
	super();
	this.spamSeq = spamSeq;
	this.word = word;
}
public int getSpamSeq() {
	return spamSeq;
}
public void setSpamSeq(int spamSeq) {
	this.spamSeq = spamSeq;
}
public String getWord() {
	return word;
}
public void setWord(String word) {
	this.word = word;
}
@Override
public String toString() {
	return "SpamWordDto [spamSeq=" + spamSeq + ", word=" + word + "]";
}
}
