package com.ssafy.happyhouse.model.dto;

public class UserDto {
	private String uid;
	private String upass;
	private String uname;
	private String ubirth;
	private String ugender;
	private String uadd;

	public UserDto() {
	}

	public UserDto(String uid, String upass, String uname, String ubirth, String ugender, String uadd) {
		this.uid = uid;
		this.upass = upass;
		this.uname = uname;
		this.ubirth = ubirth;
		this.ugender = ugender;
		this.uadd = uadd;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUbirth() {
		return ubirth;
	}

	public void setUbirth(String ubirth) {
		this.ubirth = ubirth;
	}

	public String getUgender() {
		return ugender;
	}

	public void setUgender(String ugender) {
		this.ugender = ugender;
	}

	public String getUadd() {
		return uadd;
	}

	public void setUadd(String uadd) {
		this.uadd = uadd;
	}

	@Override
	public String toString() {
		return "UserDto [uid=" + uid + ", upass=" + upass + ", uname=" + uname + ", ubirth=" + ubirth + ", ugender="
				+ ugender + ", uadd=" + uadd + "]";
	}

}