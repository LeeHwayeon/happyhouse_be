package com.ssafy.happyhouse.model.dto;

public class ParkDto {
	private String psido;
	private String pgugunName;
	private String ptype;
	private String pname;
	private String pdongName;
	private String paddress;

	public ParkDto() {
	}

	public ParkDto(String psido, String pgugunName, String ptype, String pname, String pdongName, String paddress) {
		super();
		this.psido = psido;
		this.pgugunName = pgugunName;
		this.ptype = ptype;
		this.pname = pname;
		this.pdongName = pdongName;
		this.paddress = paddress;
	}

	public String getPsido() {
		return psido;
	}

	public void setPsido(String psido) {
		this.psido = psido;
	}

	public String getPgugunName() {
		return pgugunName;
	}

	public void setPgugunName(String pgugunName) {
		this.pgugunName = pgugunName;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPdongName() {
		return pdongName;
	}

	public void setPdongName(String pdongName) {
		this.pdongName = pdongName;
	}

	public String getPaddress() {
		return paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

	@Override
	public String toString() {
		return "ParkDto [psido=" + psido + ", pgugunName=" + pgugunName + ", ptype=" + ptype + ", pname=" + pname
				+ ", pdongName=" + pdongName + ", paddress=" + paddress + "]";
	}

}
