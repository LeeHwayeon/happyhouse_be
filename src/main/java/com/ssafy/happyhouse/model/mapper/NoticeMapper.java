package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.model.dto.NoticeDto;

public interface NoticeMapper {
	public int insert(NoticeDto notice) throws SQLException;

	public int update(NoticeDto notice) throws SQLException;

	public NoticeDto selectOne(int nno) throws SQLException;

	public int Delete(int nno) throws SQLException;

	public List<NoticeDto> selectList(@Param("start") int start, @Param("count") int count) throws SQLException;

	public List<NoticeDto> searchList(@Param("start") int start, @Param("count") int count, String ntitle)
			throws SQLException;

	public int selectTotalCount() throws SQLException;

	public int updateReadCount(int nno) throws SQLException;

	public int searchTotalCount(String ntitle);

}