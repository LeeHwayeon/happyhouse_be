package com.ssafy.happyhouse.model.dto;

public class AirDto {
	private int ayear;
	private String agugunName;
	private int adust;
	private int amdust;
	private float avg;
	private int count;

	public AirDto() {
	}

	public AirDto(int ayear, String agugunName, int adust, int amdust, float avg, int count) {
		super();
		this.ayear = ayear;
		this.agugunName = agugunName;
		this.adust = adust;
		this.amdust = amdust;
		this.avg = avg;
		this.count = count;
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

	public float getAvg() {
		return avg;
	}

	public void setAvg(float avg) {
		this.avg = avg;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "AirDto [ayear=" + ayear + ", agugunName=" + agugunName + ", adust=" + adust + ", amdust=" + amdust
				+ ", avg=" + avg + ", count=" + count + "]";
	}

}
