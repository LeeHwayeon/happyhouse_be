package com.ssafy.happyhouse.model.service;

import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.model.dto.UserDto;

public interface UserService {

	UserDto login(UserDto user) throws Exception;

	int idCheck(String checkId) throws Exception;

	int registerMember(UserDto userDto) throws Exception;

	int userDelete(String uid) throws Exception;

	int userUpdate(UserDto userDto) throws Exception;
	
	int updatePass( String uid ,  String upass) throws Exception;

	public UserDto userInfo(String uid) throws Exception;
	
	int userCheck(String uid , String uname ) throws Exception;
}
