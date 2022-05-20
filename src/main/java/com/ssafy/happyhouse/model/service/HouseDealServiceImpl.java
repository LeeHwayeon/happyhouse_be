package com.ssafy.happyhouse.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.HouseDealDto;
import com.ssafy.happyhouse.model.mapper.HouseDealMapper;

@Service
public class HouseDealServiceImpl implements HouseDealService {

	@Autowired
	private HouseDealMapper mapper;

	@Override
	public List<HouseDealDto> selectSidoApt(String sidocode) throws Exception {
		return mapper.selectSidoApt(sidocode);
	}

	@Override
	public List<HouseDealDto> selectGugunApt(String guguncode) throws Exception {
		return mapper.selectGugunApt(guguncode);
	}

	@Override
	public List<HouseDealDto> selectDongApt(String dongcode) throws Exception {
		return mapper.selectDongApt(dongcode);
	}

	@Override
	public List<HouseDealDto> selectAptname(String aptname) throws Exception {
		return mapper.selectAptname(aptname);
	}

	@Override
	public List<HouseDealDto> selectApt(String dongcode, String aptname) throws Exception {
		return mapper.selectApt(dongcode, aptname);
	}

	
	

}
