package com.ssafy.happyhouse.model.dto;

public class SubwayDto {
	private int tline;
	private String tname;
	private String tdoro;
	private String tjibun;

	public SubwayDto() {
	}

	public SubwayDto(int tline, String tname, String tdoro, String tjibun) {
		super();
		this.tline = tline;
		this.tname = tname;
		this.tdoro = tdoro;
		this.tjibun = tjibun;
	}

	public int getTline() {
		return tline;
	}

	public void setTline(int tline) {
		this.tline = tline;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTdoro() {
		return tdoro;
	}

	public void setTdoro(String tdoro) {
		this.tdoro = tdoro;
	}

	public String getTjibun() {
		return tjibun;
	}

	public void setTjibun(String tjibun) {
		this.tjibun = tjibun;
	}

	@Override
	public String toString() {
		return "SubwayDto [tline=" + tline + ", tname=" + tname + ", tdoro=" + tdoro + ", tjibun=" + tjibun + "]";
	}

}
