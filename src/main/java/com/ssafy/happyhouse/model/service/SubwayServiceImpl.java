package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.SubwayDto;
import com.ssafy.happyhouse.model.mapper.SubwayMapper;

@Service
public class SubwayServiceImpl implements SubwayService {

	@Autowired
	private SubwayMapper mapper;

	@Override
	public List<SubwayDto> selectListAll() throws Exception {
		return mapper.selectListAll();
	}

}
