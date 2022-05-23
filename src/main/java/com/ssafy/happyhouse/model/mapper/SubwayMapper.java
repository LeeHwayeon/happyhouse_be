package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.SubwayDto;

public interface SubwayMapper {
	List<SubwayDto> selectListAll() throws SQLException;
}
