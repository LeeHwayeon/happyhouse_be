package com.ssafy.happyhouse.model.dto;

public class GymDto {
	private int swork;
	private String sopen;
	private String sjibun;
	private String sdoro;
	private String sname;
	private String sx;
	private String sy;

	public GymDto() {
	}

	public int getSwork() {
		return swork;
	}

	public void setSwork(int swork) {
		this.swork = swork;
	}

	public String getSopen() {
		return sopen;
	}

	public void setSopen(String sopen) {
		this.sopen = sopen;
	}

	public String getSjibun() {
		return sjibun;
	}

	public void setSjibun(String sjibun) {
		this.sjibun = sjibun;
	}

	public String getSdoro() {
		return sdoro;
	}

	public void setSdoro(String sdoro) {
		this.sdoro = sdoro;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSx() {
		return sx;
	}

	public void setSx(String sx) {
		this.sx = sx;
	}

	public String getSy() {
		return sy;
	}

	public void setSy(String sy) {
		this.sy = sy;
	}

	@Override
	public String toString() {
		return "GymDto [swork=" + swork + ", sopen=" + sopen + ", sjibun=" + sjibun + ", sdoro=" + sdoro + ", sname="
				+ sname + ", sx=" + sx + ", sy=" + sy + "]";
	}

}
