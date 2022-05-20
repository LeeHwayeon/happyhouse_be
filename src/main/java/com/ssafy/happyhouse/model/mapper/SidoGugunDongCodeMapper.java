package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.SidoGugunDongCodeDto;

public interface SidoGugunDongCodeMapper {

	List<SidoGugunDongCodeDto> selectSido() throws SQLException;

	List<SidoGugunDongCodeDto> selectGugun(String sidocode) throws SQLException;

	List<SidoGugunDongCodeDto> selectDong(String guguncode) throws SQLException;

}
