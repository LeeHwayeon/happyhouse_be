package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.AirDto;

public interface AirService {
	List<AirDto> selectGu(String gugunName) throws Exception;
	
	List<AirDto> avgResult() throws Exception;

}
