package com.ssafy.happyhouse.model.service;

import java.util.Map;

import com.ssafy.happyhouse.model.dto.UserDto;

public interface UserService {
	
	UserDto login(Map<String, String> map) throws Exception;
	
	int idCheck(String checkId) throws Exception;
	void registerMember(UserDto userDto) throws Exception;
	
	int userDelete(String uid) throws Exception;
	int userUpdate(UserDto userDto) throws Exception;
}
