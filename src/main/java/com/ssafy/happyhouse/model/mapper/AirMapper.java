package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.AirDto;

public interface AirMapper {
	List<AirDto> selectGu(String gugunName) throws SQLException;

	List<AirDto> avgResult() throws SQLException;
}
