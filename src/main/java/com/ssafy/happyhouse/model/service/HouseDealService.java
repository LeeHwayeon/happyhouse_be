package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.HouseDeal;

public interface HouseDealService {

	List<HouseDeal> selectDongDeal(String dongName) throws Exception;

	List<HouseDeal> selectAptDeal(String aptName) throws Exception;

	List<HouseDeal> selectDongAptName(String dongName, String aptName) throws Exception;

}
