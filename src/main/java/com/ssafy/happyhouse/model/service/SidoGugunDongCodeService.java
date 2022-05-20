package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.SidoGugunDongCodeDto;

public interface SidoGugunDongCodeService {
	List<SidoGugunDongCodeDto> selectSido() throws Exception;

	List<SidoGugunDongCodeDto> selectGugun(String sidocode) throws Exception;

	List<SidoGugunDongCodeDto> selectDong(String guguncode) throws Exception;
	
	SidoGugunDongCodeDto selectaddress(String addcode) throws Exception;
}
