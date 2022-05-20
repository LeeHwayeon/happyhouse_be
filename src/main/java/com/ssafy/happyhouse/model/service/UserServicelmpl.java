package com.ssafy.happyhouse.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.UserDto;
import com.ssafy.happyhouse.model.mapper.UserMapper;

@Service
public class UserServicelmpl implements UserService {

	@Autowired
	private UserMapper usermapper;

	@Override
	public int idCheck(String checkId) throws Exception {
		return usermapper.idCheck(checkId);
	}

	@Override
	public int registerMember(UserDto userDto) throws Exception {
		return usermapper.registerMember(userDto);
	}

	@Override
	public UserDto login(UserDto user) throws Exception {
		if (user.getUid() == null || user.getUpass() == null)
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

	@Override
	public int userCheck(String uid, String uname) throws Exception {
		System.out.println(usermapper.userCheck(uid, uname));
		return usermapper.userCheck(uid, uname);
	}

	@Override
	public int updatePass(String uid, String upass) throws Exception {
		return usermapper.updatePass(uid, upass);
	}
}
