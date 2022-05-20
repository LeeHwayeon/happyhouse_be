package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.SidoGugunDongCodeDto;

public interface SidoGugunDongCodeService {
	List<SidoGugunDongCodeDto> selectSido() throws Exception;

	List<SidoGugunDongCodeDto> selectGugun(String sidocode) throws Exception;

	List<SidoGugunDongCodeDto> selectDong(String guguncode) throws Exception;

	SidoGugunDongCodeDto selectAddress(String addcode) throws Exception;
}
