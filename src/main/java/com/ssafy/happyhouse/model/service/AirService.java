package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.AirDto;

public interface AirService {
	Integer selectGu(String dongCode) throws Exception;
	
	List<AirDto> avgResult() throws Exception;
	
	List<AirDto> gugunAirSix(String dongCode) throws Exception;


}
