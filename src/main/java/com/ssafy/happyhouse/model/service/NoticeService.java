package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.Map;

import com.ssafy.happyhouse.model.dto.NoticeDto;

public interface NoticeService {
	public int write(NoticeDto notice) throws SQLException;

	public Map<String, Object> makePage(int page) throws SQLException;

	public Map<String, Object> search(int page, String ntitle) throws SQLException;

	public Map<String, Object> read(int nno,String userid) throws SQLException;

	public int delete(int nno) throws SQLException;

	public int update(NoticeDto notice) throws SQLException;

}
