package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.dto.HouseDealDto;
import com.ssafy.happyhouse.model.dto.HouseDealTopTenDto;

public interface HouseDealService {

	// 시도 입력
	List<HouseDealDto> selectSidoApt(String sidocode) throws Exception;

	// 시도 구군 입력
	Map<String, Object> selectSidoGugunApt(String guguncode, int buildyear,int aptprice, int page) throws Exception;
	
	// 시도 구군 동 입력
	Map<String, Object> selectDongApt(String dongcode, int buildyear,int aptprice, int page) throws Exception;

	// 아파트이름 입력
	Map<String, Object> selectAptname(String guguncode, int buildyear,int aptprice, int page , String aptname) throws Exception;

	// 시도 구군 동 아파트이름 모두 입력
	Map<String, Object> selectApt(String dongcode, int buildyear,int aptprice, int page , String aptname) throws Exception;

	// 아파트 상세
	List<HouseDealDto> selectDetail(long aptCode) throws Exception;
	
	List<HouseDealTopTenDto> selectDeal() throws Exception;


}
