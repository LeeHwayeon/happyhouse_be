package com.ssafy.happyhouse.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.model.dto.UserDto;

public interface UserMapper {
	
	UserDto login(Map<String, String> map) throws Exception;
	
	int idCheck(String checkId) throws Exception;
	void registerMember(UserDto userDto) throws Exception;
	
	int userDelete(String uid) throws Exception;
	int userUpdate(UserDto userDto) throws Exception;
}