package com.ssafy.happyhouse.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.model.dto.UserDto;

public interface UserMapper {
	
	UserDto login(UserDto user) throws Exception;
	
	int idCheck(String checkId) throws Exception;
	int registerMember(UserDto userDto) throws Exception;
	
	int userDelete(String uid) throws Exception;
	int userUpdate(UserDto userDto) throws Exception;
	
	public UserDto userInfo(String uid) throws Exception;
}