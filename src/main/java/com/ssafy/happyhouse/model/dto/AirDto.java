package com.ssafy.happyhouse.model.dto;

public class AirDto {
	private int ayear;
	private String agugunName;
	private int adust;
	private int amdust;

	public AirDto() {
	}

	public AirDto(int ayear, String agugunName, int adust, int amdust) {
		super();
		this.ayear = ayear;
		this.agugunName = agugunName;
		this.adust = adust;
		this.amdust = amdust;
	}

	public int getAyear() {
		return ayear;
	}

	public void setAyear(int ayear) {
		this.ayear = ayear;
	}

	public String getAgugunName() {
		return agugunName;
	}

	public void setAgugunName(String agugunName) {
		this.agugunName = agugunName;
	}

	public int getAdust() {
		return adust;
	}

	public void setAdust(int adust) {
		this.adust = adust;
	}

	public int getAmdust() {
		return amdust;
	}

	public void setAmdust(int amdust) {
		this.amdust = amdust;
	}

	@Override
	public String toString() {
		return "AirDto [ayear=" + ayear + ", agugunName=" + agugunName + ", adust=" + adust + ", amdust=" + amdust
				+ "]";
	}

}
