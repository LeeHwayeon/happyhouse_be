package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.model.dto.HouseDealDto;

public interface HouseDealMapper {

	// 시도 입력
	List<HouseDealDto> selectSidoApt(String sidocode) throws SQLException;

	// 시도 구군 입력
	List<HouseDealDto> selectGugunApt(String guguncode) throws SQLException;

	// 시도 구군 동 입력
	List<HouseDealDto> selectDongApt(String dongcode) throws SQLException;

	// 아파트이름 입력
	List<HouseDealDto> selectAptname(String aptname) throws SQLException;

	// 시도 구군 동 아파트이름 모두 입력
	List<HouseDealDto> selectApt(@Param(value = "dongcode") String dongcode,@Param(value = "aptname") String aptname ) throws SQLException;

	

}
