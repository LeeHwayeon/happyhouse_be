package com.ssafy.happyhouse.model.dto;

public class SidoGugunDongCodeDto {

	private String sidoCode;
	private String sidoName;
	private String gugunCode;
	private String gugunName;
	private String dongName;
	private String dongCode;
	private String lat;
	private String lng;

	public SidoGugunDongCodeDto() {
	}

	public SidoGugunDongCodeDto(String sidoCode, String sidoName, String gugunCode, String gugunName, String dongName,
			String dongCode, String lat, String lng) {
		super();
		this.sidoCode = sidoCode;
		this.sidoName = sidoName;
		this.gugunCode = gugunCode;
		this.gugunName = gugunName;
		this.dongName = dongName;
		this.dongCode = dongCode;
		this.lat = lat;
		this.lng = lng;
	}

	public String getSidoCode() {
		return sidoCode;
	}

	public void setSidoCode(String sidoCode) {
		this.sidoCode = sidoCode;
	}

	public String getSidoName() {
		return sidoName;
	}

	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}

	public String getGugunCode() {
		return gugunCode;
	}

	public void setGugunCode(String gugunCode) {
		this.gugunCode = gugunCode;
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

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
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
		return "SidoGugunCodeDto [sidoCode=" + sidoCode + ", sidoName=" + sidoName + ", gugunCode=" + gugunCode
				+ ", gugunName=" + gugunName + ", dongName=" + dongName + ", dongCode=" + dongCode + ", lat=" + lat
				+ ", lng=" + lng + "]";
	}

}
