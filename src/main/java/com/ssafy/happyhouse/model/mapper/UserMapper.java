package com.ssafy.happyhouse.model.mapper;

import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.model.dto.UserDto;

public interface UserMapper {

	UserDto login(UserDto user) throws Exception;

	int idCheck(String checkId) throws Exception;

	int registerMember(UserDto userDto) throws Exception;

	int userDelete(String uid) throws Exception;

	int userUpdate(UserDto userDto) throws Exception;

	int updatePass(@Param("uid") String uid , @Param("upass") String upass) throws Exception;
	
	public UserDto userInfo(String uid) throws Exception;
	
	int userCheck(@Param("uid") String uid , @Param("uname") String uname ) throws Exception;
}