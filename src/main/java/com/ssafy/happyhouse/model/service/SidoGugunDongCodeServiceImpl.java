package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.SidoGugunDongCodeDto;
import com.ssafy.happyhouse.model.mapper.SidoGugunDongCodeMapper;

@Service
public class SidoGugunDongCodeServiceImpl implements SidoGugunDongCodeService {

	@Autowired
	private SidoGugunDongCodeMapper mapper;

	@Override
	public List<SidoGugunDongCodeDto> selectSido() throws Exception {
		return mapper.selectSido();
	}

	@Override
	public List<SidoGugunDongCodeDto> selectGugun(String sidocode) throws Exception {
		return mapper.selectGugun(sidocode);
	}

	@Override
	public List<SidoGugunDongCodeDto> selectDong(String guguncode) throws Exception {
		return mapper.selectDong(guguncode);
	}

}
