package com.ssafy.happyhouse.model.service;

import java.util.Map;

import com.ssafy.happyhouse.model.dto.UserDto;

public interface UserService {
	
	UserDto login(UserDto user) throws Exception;
	
	int idCheck(String checkId) throws Exception;
	void registerMember(UserDto userDto) throws Exception;
	
	int userDelete(String uid) throws Exception;
	int userUpdate(UserDto userDto) throws Exception;
	
	public UserDto userInfo(String uid) throws Exception;
}
