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
	public Integer selectGu(String dongCode) throws Exception {
		System.out.println(mapper.selectGu(dongCode));
		return mapper.selectGu(dongCode);
	}

	@Override
	public List<AirDto> avgResult() throws Exception {
		return mapper.avgResult();
	}

	@Override
	public List<AirDto> gugunAirSix(String dongCode) throws Exception {
		System.out.println(mapper.gugunAirSix(dongCode));
		return mapper.gugunAirSix(dongCode);
	}

}
