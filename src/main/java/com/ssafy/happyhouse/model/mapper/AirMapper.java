package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.AirDto;

public interface AirMapper {
	Integer selectGu(String dongCode) throws SQLException;
	
	List<AirDto> gugunAirSix(String dongCode) throws SQLException;

	List<AirDto> avgResult() throws SQLException;
}
