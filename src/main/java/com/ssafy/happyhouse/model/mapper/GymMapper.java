package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.GymDto;

public interface GymMapper {
	public List<GymDto> selectList() throws SQLException;
}
