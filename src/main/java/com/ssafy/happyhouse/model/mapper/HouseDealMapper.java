package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.HouseDeal;

public interface HouseDealMapper {

	List<HouseDeal> selectDongDeal(String dongName) throws SQLException;

	List<HouseDeal> selectAptDeal(String aptName) throws SQLException;

	List<HouseDeal> selectDongAptName(String dongName, String aptName) throws SQLException;

}
