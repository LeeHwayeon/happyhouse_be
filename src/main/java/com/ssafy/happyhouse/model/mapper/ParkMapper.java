package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.model.dto.ParkDto;



public interface ParkMapper {
	public List<ParkDto> selectList(String dong) throws SQLException;
}
