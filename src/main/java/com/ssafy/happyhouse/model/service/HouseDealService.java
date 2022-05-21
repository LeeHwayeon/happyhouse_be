package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.dto.HouseDealDto;

public interface HouseDealService {

	// 시도 입력
	List<HouseDealDto> selectSidoApt(String sidocode) throws Exception;

	// 시도 구군 입력
	Map<String, Object> selectSidoGugunApt(String guguncode, int buildyear,int aptprice, int page) throws Exception;
	
	// 시도 구군 동 입력
	List<HouseDealDto> selectDongApt(String dongcode) throws Exception;

	// 아파트이름 입력
	List<HouseDealDto> selectAptname(String aptname, String guguncode) throws Exception;

	// 시도 구군 동 아파트이름 모두 입력
	List<HouseDealDto> selectApt(String dongcode, String aptname) throws Exception;

}
