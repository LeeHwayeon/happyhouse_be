package com.ssafy.happyhouse.model.dto;

public class HouseDealDto {
	private String dealAmount;
	private int dealYear;
	private int dealMonth;
	private int dealDay;
	private String area;
	private String floor;
	private long aptCode;
	private int buildYear;
	private String dongCode;
	private String apartmentName;
	private String lat;
	private String lng;
	private int count;
	private int min;
	private int max;
	private String dong;

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

	public int getDealYear() {
		return dealYear;
	}

	public void setDealYear(int dealYear) {
		this.dealYear = dealYear;
	}

	public int getDealMonth() {
		return dealMonth;
	}

	public void setDealMonth(int dealMonth) {
		this.dealMonth = dealMonth;
	}

	public int getDealDay() {
		return dealDay;
	}

	public void setDealDay(int dealDay) {
		this.dealDay = dealDay;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public long getAptCode() {
		return aptCode;
	}

	public void setAptCode(long aptCode) {
		this.aptCode = aptCode;
	}

	public int getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(int buildYear) {
		this.buildYear = buildYear;
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public String getApartmentName() {
		return apartmentName;
	}

	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
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

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public HouseDealDto(String dealAmount, int dealYear, int dealMonth, int dealDay, String area, String floor,
			long aptCode, int buildYear, String dongCode, String apartmentName, String lat, String lng, int count,
			int min, int max, String dong) {
		super();
		this.dealAmount = dealAmount;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealDay = dealDay;
		this.area = area;
		this.floor = floor;
		this.aptCode = aptCode;
		this.buildYear = buildYear;
		this.dongCode = dongCode;
		this.apartmentName = apartmentName;
		this.lat = lat;
		this.lng = lng;
		this.count = count;
		this.min = min;
		this.max = max;
		this.dong = dong;
	}

	public HouseDealDto() {
		super();
	}

	@Override
	public String toString() {
		return "HouseDealDto [dealAmount=" + dealAmount + ", dealYear=" + dealYear + ", dealMonth=" + dealMonth
				+ ", dealDay=" + dealDay + ", area=" + area + ", floor=" + floor + ", aptCode=" + aptCode
				+ ", buildYear=" + buildYear + ", dongCode=" + dongCode + ", apartmentName=" + apartmentName + ", lat="
				+ lat + ", lng=" + lng + ", count=" + count + ", min=" + min + ", max=" + max + ", dong=" + dong + "]";
	}

}
