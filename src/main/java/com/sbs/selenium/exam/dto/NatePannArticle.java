package com.sbs.selenium.exam.dto;

public class NatePannArticle {
	private String title; 
	private int count; 
	private int rcm; 
	private String url;
	private int id;

	public NatePannArticle(String title, int count, int rcm, String url, int id) {
		this.title = title;
		this.count = count;
		this.rcm = rcm;
		this.url = url;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "NatePannArticle [title=" + title + ", count=" + count + ", rcm=" + rcm + ", url=" + url + ", id=" + id
				+ "]";
	}

}
