package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.SubwayDto;

public interface SubwayService {
	List<SubwayDto> selectListAll() throws Exception;

}
