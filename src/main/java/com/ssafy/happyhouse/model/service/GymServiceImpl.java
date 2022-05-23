package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.GymDto;
import com.ssafy.happyhouse.model.mapper.GymMapper;

@Service
public class GymServiceImpl implements GymService {
	
	@Autowired 
	private GymMapper mapper;

	@Override
	public List<GymDto> selectList() throws Exception {
		return mapper.selectList();
	}
	
}
