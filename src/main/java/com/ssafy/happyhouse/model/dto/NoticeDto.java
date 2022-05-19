package com.ssafy.happyhouse.model.dto;

public class NoticeDto {
	private int nno;
	private String nwriter;
	private String ntitle;
	private String ncontext;
	private String ndate;
	private int ncount;

	public NoticeDto() {
	}

	public NoticeDto(int nno, String nwriter, String ntitle, String ncontext, String ndate, int ncount) {
		super();
		this.nno = nno;
		this.nwriter = nwriter;
		this.ntitle = ntitle;
		this.ncontext = ncontext;
		this.ndate = ndate;
		this.ncount = ncount;
	}

	public NoticeDto(String ntitle, String ncontext) {
		super();
		this.ntitle = ntitle;
		this.ncontext = ncontext;
	}

	public int getNno() {
		return nno;
	}

	public void setNno(int nno) {
		this.nno = nno;
	}

	public String getNwriter() {
		return nwriter;
	}

	public void setNwriter(String nwriter) {
		this.nwriter = nwriter;
	}

	public String getNtitle() {
		return ntitle;
	}

	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}

	public String getNcontext() {
		return ncontext;
	}

	public void setNcontext(String ncontext) {
		this.ncontext = ncontext;
	}

	public String getNdate() {
		return ndate;
	}

	public void setNdate(String ndate) {
		this.ndate = ndate;
	}

	public int getNcount() {
		return ncount;
	}

	public void setNcount(int ncount) {
		this.ncount = ncount;
	}

	@Override
	public String toString() {
		return "NoticeDto [nno=" + nno + ", nwriter=" + nwriter + ", ntitle=" + ntitle + ", ncontext=" + ncontext
				+ ", ndate=" + ndate + ", ncount=" + ncount + "]";
	}

}