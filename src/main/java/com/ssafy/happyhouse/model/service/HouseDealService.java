package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.HouseDealDto;

public interface HouseDealService {

	// 시도 입력
	List<HouseDealDto> selectSidoApt(String sidocode) throws Exception;

	// 시도 구군 입력
	List<HouseDealDto> selectGugunApt(String guguncode) throws Exception;

	// 시도 구군 동 입력
	List<HouseDealDto> selectDongApt(String dongcode) throws Exception;

	// 아파트이름 입력
	List<HouseDealDto> selectAptname(String aptname) throws Exception;

	// 시도 구군 동 아파트이름 모두 입력
	List<HouseDealDto> selectApt(String dongcode, String aptname) throws Exception;

}
