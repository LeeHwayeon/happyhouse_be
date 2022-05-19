package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.HouseInfo;
import com.ssafy.happyhouse.model.mapper.HouseInfoMapper;

@Service
public class HouseInfoServiceImpl implements HouseInfoService {

	@Autowired
	private HouseInfoMapper mapper;

	@Override
	public List<HouseInfo> selectGu() throws Exception {
		return mapper.selectGu();
	}

	@Override
	public List<HouseInfo> selectDong() throws Exception {
		return mapper.selectDong();
	}

	@Override
	public List<HouseInfo> selectGuDong() throws Exception {
		return mapper.selectGuDong();
	}

	@Override
	public HouseInfo selectDetail(int aptCode) throws Exception {
 		return mapper.selectDetail(aptCode);
	}

}
