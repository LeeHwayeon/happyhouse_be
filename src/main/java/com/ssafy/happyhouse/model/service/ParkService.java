package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.ParkDto;

public interface ParkService {
	public List<ParkDto> selectList(String dong, double lat, double lng) throws Exception;

}
