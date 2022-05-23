package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import com.ssafy.happyhouse.model.dto.AirDto;


public interface AirMapper {
	List<AirDto> list(String dong);
}
