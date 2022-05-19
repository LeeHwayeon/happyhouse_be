package com.ssafy.happyhouse.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.UserDto;
import com.ssafy.happyhouse.model.mapper.UserMapper;

@Service
public class UserServicelmpl implements UserService{
	
	@Autowired
	private UserMapper usermapper;
	
	@Override
	public int idCheck(String checkId) throws Exception {
		return usermapper.idCheck(checkId);
	}
	
	@Override
	public void registerMember(UserDto userDto) throws Exception {
		usermapper.registerMember(userDto);
	}
	
	@Override
	public UserDto login(UserDto user) throws Exception {
		if(user.getUid() == null || user.getUpass() == null)
			return null;
		return usermapper.login(user);
	}

	@Override
	public int userDelete(String uid) throws Exception {
		return usermapper.userDelete(uid);
	}

	@Override
	public int userUpdate(UserDto userDto) throws Exception {
		return usermapper.userUpdate(userDto);
	}
	
	@Override
	public UserDto userInfo(String uid) throws Exception {
		return usermapper.userInfo(uid);
	}
}
