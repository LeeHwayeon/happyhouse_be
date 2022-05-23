package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.GymDto;

public interface GymService {
	public List<GymDto> selectList(String dong) throws Exception;
}
