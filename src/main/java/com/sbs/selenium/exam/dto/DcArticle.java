package com.sbs.selenium.exam.dto;

public class DcArticle {
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNo() {
		return id;
	}

	public void setNo(int id) {
		this.id = id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getRcm() {
		return rcm;
	}

	public void setRcm(int rcm) {
		this.rcm = rcm;
	}

	private String title;
	private int id;
	private String writer;
	private int count;
	private int rcm;
	private String regDate;
	
	public DcArticle(int id, String title, String writer, String regDate, int count, int rcm) {
		this.title = title;
		this.id = id;
		this.writer = writer;
		this.count = count;
		this.rcm = rcm;
		this.regDate = regDate;
		
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "DcArticle [title=" + title + ", no=" + id + ", writer=" + writer + ", count=" + count + ", rcm=" + rcm
				+ ", regDate=" + regDate + "]";
	}
	

}

