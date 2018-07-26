package com.example.demo.dto;

import java.util.Date;

public class BoardDto {
	private int idx;
	private String title;
	private String content;
	private int view_cnt;
	private Date reg_date;
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardDto(int idx, String title, String content, int view_cnt, Date reg_date) {
		super();
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.view_cnt = view_cnt;
		this.reg_date = reg_date;
	}
	
	public BoardDto(int idx, String title, String content) {
		super();
		this.idx = idx;
		this.title = title;
		this.content = content;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
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
	public int getView_cnt() {
		return view_cnt;
	}
	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "BoardDto [idx=" + idx + ", title=" + title + ", content=" + content + ", view_cnt=" + view_cnt
				+ ", reg_date=" + reg_date + "]";
	}
	
	
	
}
