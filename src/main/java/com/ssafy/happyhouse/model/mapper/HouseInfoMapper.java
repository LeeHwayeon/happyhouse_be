package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.HouseInfo;

public interface HouseInfoMapper {
	List<HouseInfo> selectGuDong() throws SQLException;

	List<HouseInfo> selectGu() throws SQLException;

	List<HouseInfo> selectDong() throws SQLException;

	HouseInfo selectDetail(int aptCode) throws SQLException;
}
