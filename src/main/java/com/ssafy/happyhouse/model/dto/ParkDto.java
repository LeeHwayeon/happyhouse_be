package com.ssafy.happyhouse.model.dto;

public class ParkDto {
	private String pname;
	private String ptype;
	private String pdoro;
	private String pjibun;
	private String plat;
	private String plng;
	private String parea;

	public ParkDto() {
	}

	public ParkDto(String pname, String ptype, String pdoro, String pjibun, String plat, String plng, String parea) {
		super();
		this.pname = pname;
		this.ptype = ptype;
		this.pdoro = pdoro;
		this.pjibun = pjibun;
		this.plat = plat;
		this.plng = plng;
		this.parea = parea;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public String getPdoro() {
		return pdoro;
	}

	public void setPdoro(String pdoro) {
		this.pdoro = pdoro;
	}

	public String getPjibun() {
		return pjibun;
	}

	public void setPjibun(String pjibun) {
		this.pjibun = pjibun;
	}

	public String getPlat() {
		return plat;
	}

	public void setPlat(String plat) {
		this.plat = plat;
	}

	public String getPlng() {
		return plng;
	}

	public void setPlng(String plng) {
		this.plng = plng;
	}

	public String getParea() {
		return parea;
	}

	public void setParea(String parea) {
		this.parea = parea;
	}

	@Override
	public String toString() {
		return "ParkDto [pname=" + pname + ", ptype=" + ptype + ", pdoro=" + pdoro + ", pjibun=" + pjibun + ", plat="
				+ plat + ", plng=" + plng + ", parea=" + parea + "]";
	}

}
