package com.sbs.selenium.exam.dto;

public class NaverNewsArticle {

	public NaverNewsArticle(String title, String writer, String body, String img) {
		this.body = body;
		this.img = img;
		this.writer = writer;
		this.img = img;
	}
	
	private String title;
	private String writer;
	private String body;
	private String img;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "NaverNewsArticle [title=" + title + ", writer=" + writer + ", body=" + body + ", img=" + img + "]";
	}
	

}
