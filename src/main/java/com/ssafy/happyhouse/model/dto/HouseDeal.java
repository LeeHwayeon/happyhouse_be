package com.ssafy.happyhouse.model.dto;

public class HouseDeal {
	int no, aptCode;
	String dealAmount;
	int dealYear, dealMonth, dealDay;
	String area, floor, type, rentMoney;

	String aptName, dongName, lat, lng;

	public HouseDeal(String aptName, String dongName, String dealAmount, int aptCode, String lat, String lng) {
		super();
		this.aptName = aptName;
		this.dongName = dongName;
		this.dealAmount = dealAmount;
		this.aptCode = aptCode;
		this.lat = lat;
		this.lng = lng;
	}

	public HouseDeal(String aptName, String dongName, String dealAmount, int aptCode, String lat, String lng, int no) {
		super();
		this.aptName = aptName;
		this.dongName = dongName;
		this.dealAmount = dealAmount;
		this.aptCode = aptCode;
		this.lat = lat;
		this.lng = lng;
		this.no = no;
	}

	public String getAptName() {
		return aptName;
	}

	public void setAptName(String aptName) {
		this.aptName = aptName;
	}

	public String getDongName() {
		return dongName;
	}

	public void setDongName(String dongName) {
		this.dongName = dongName;
	}

	public HouseDeal(int no, int aptCode, String dealAmount, int dealYear, int dealMonth, int dealDay, String area,
			String floor, String type, String rentMoney) {
		super();
		this.no = no;
		this.aptCode = aptCode;
		this.dealAmount = dealAmount;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealDay = dealDay;
		this.area = area;
		this.floor = floor;
		this.type = type;
		this.rentMoney = rentMoney;
	}

	public HouseDeal(int no, int aptCode, String dealAmount, int dealYear, int dealMonth, int dealDay, String area,
			String floor, String type) {
		super();
		this.no = no;
		this.aptCode = aptCode;
		this.dealAmount = dealAmount;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealDay = dealDay;
		this.area = area;
		this.floor = floor;
		this.type = type;
	}

	public HouseDeal(int aptCode, String dealAmount, int dealYear, int dealMonth, int dealDay, String area,
			String floor, String type) {
		super();
		this.aptCode = aptCode;
		this.dealAmount = dealAmount;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealDay = dealDay;
		this.area = area;
		this.floor = floor;
		this.type = type;
	}

	public HouseDeal(String dealAmount) {
		super();
		this.dealAmount = dealAmount;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getAptCode() {
		return aptCode;
	}

	public void setAptCode(int aptCode) {
		this.aptCode = aptCode;
	}

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRentMoney() {
		return rentMoney;
	}

	public void setRentMoney(String rentMoney) {
		this.rentMoney = rentMoney;
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

	@Override
	public String toString() {
		return "HouseDeal [no=" + no + ", aptCode=" + aptCode + ", dealAmount=" + dealAmount + ", dealYear=" + dealYear
				+ ", dealMonth=" + dealMonth + ", dealDay=" + dealDay + ", area=" + area + ", floor=" + floor
				+ ", type=" + type + ", rentMoney=" + rentMoney + ", aptName=" + aptName + ", dongName=" + dongName
				+ "]";
	}

}
