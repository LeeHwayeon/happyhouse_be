package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.model.dto.HouseDealDto;

public interface HouseDealMapper {

	// 시도 입력
	List<HouseDealDto> selectSidoApt(String sidocode) throws SQLException;

	// 시도 구군 입력
	List<HouseDealDto> selectSidoGugunApt(@Param(value = "guguncode") String guguncode,
			@Param(value = "buildyear") int buildyear, @Param(value = "aptprice") int aptprice,
			@Param(value = "page") int page) throws SQLException;

	int selectSidototal(@Param(value = "guguncode") String guguncode, @Param(value = "buildyear") int buildyear,
			@Param(value = "aptprice") int aptprice) throws SQLException;

	// 시도 구군 동 입력
	List<HouseDealDto> selectDongApt(@Param(value = "dongcode") String dongcode,
			@Param(value = "buildyear") int buildyear, @Param(value = "aptprice") int aptprice,
			@Param(value = "page") int page) throws SQLException;

	int selectDongApttotal(@Param(value = "dongcode") String dongcode, @Param(value = "buildyear") int buildyear,
			@Param(value = "aptprice") int aptprice) throws SQLException;

	// 아파트이름 입력
	List<HouseDealDto> selectAptname(@Param(value = "aptname") String aptname,
			@Param(value = "guguncode") String guguncode, @Param(value = "buildyear") int buildyear,
			@Param(value = "aptprice") int aptprice, @Param(value = "page") int page) throws SQLException;

	int selectAptnametotal(@Param(value = "aptname") String aptname, @Param(value = "guguncode") String guguncode,
			@Param(value = "buildyear") int buildyear, @Param(value = "aptprice") int aptprice) throws SQLException;

	// 시도 구군 동 아파트이름 모두 입력
	List<HouseDealDto> selectApt(@Param(value = "aptname") String aptname, @Param(value = "dongcode") String dongcode,
			@Param(value = "buildyear") int buildyear, @Param(value = "aptprice") int aptprice,
			@Param(value = "page") int page) throws SQLException;

	int selectApttotal(@Param(value = "aptname") String aptname, @Param(value = "dongcode") String dongcode,
			@Param(value = "buildyear") int buildyear, @Param(value = "aptprice") int aptprice) throws SQLException;

	// 아파트 상세 정보
	List<HouseDealDto> selectDetail(long aptCode) throws SQLException;
	
	// 2022년 4월 거래 많이 된 시군구 조회하기
	List<HouseDealDto> selectDeal() throws SQLException;

}
