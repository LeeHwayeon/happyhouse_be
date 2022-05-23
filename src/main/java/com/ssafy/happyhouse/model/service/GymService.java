package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.GymDto;

public interface GymService {
	public List<GymDto> selectList() throws Exception;
}
