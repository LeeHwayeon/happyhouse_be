package com.ssafy.happyhouse.model.dto;

public class CommentDto {
	private int cno;
	private int nno;
	private String cwriter;
	private String ccontent;
	
	
	public CommentDto(int nno, String cwriter, String ccontent) {
		super();
		this.nno = nno;
		this.cwriter = cwriter;
		this.ccontent = ccontent;
	}


	public CommentDto() {
		super();
	}
	
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getNno() {
		return nno;
	}
	public void setNno(int nno) {
		this.nno = nno;
	}
	public String getCwriter() {
		return cwriter;
	}
	public void setCwriter(String cwriter) {
		this.cwriter = cwriter;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	
	
}