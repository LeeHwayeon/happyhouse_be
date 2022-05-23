package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.AirDto;
import com.ssafy.happyhouse.model.mapper.AirMapper;

@Service
public class AirServiceImpl implements AirService{

	@Autowired
	private AirMapper mapper;
	
	@Override
	public List<AirDto> selectGu(String gugunName) throws Exception {
		return mapper.selectGu(gugunName);
	}

	@Override
	public List<AirDto> avgResult() throws Exception {
		return mapper.avgResult();
	}

}
