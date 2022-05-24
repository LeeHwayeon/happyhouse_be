package com.ssafy.happyhouse.model.dto;

public class HouseDealTopTenDto {
	private String dongCode;
	private int count;
	private int min;
	private int max;
	private String sidoName;
	private String gugunName;
	private String dongName;

	public HouseDealTopTenDto() {
	}

	public HouseDealTopTenDto(String dongCode, int count, int min, int max, String sidoName, String gugunName,
			String dongName) {
		super();
		this.dongCode = dongCode;
		this.count = count;
		this.min = min;
		this.max = max;
		this.sidoName = sidoName;
		this.gugunName = gugunName;
		this.dongName = dongName;
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public String getSidoName() {
		return sidoName;
	}

	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}

	public String getGugunName() {
		return gugunName;
	}

	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}

	public String getDongName() {
		return dongName;
	}

	public void setDongName(String dongName) {
		this.dongName = dongName;
	}

	@Override
	public String toString() {
		return "HouseDealTopTenDto [dongCode=" + dongCode + ", count=" + count + ", min=" + min + ", max=" + max
				+ ", sidoName=" + sidoName + ", gugunName=" + gugunName + ", dongName=" + dongName + "]";
	}

}
