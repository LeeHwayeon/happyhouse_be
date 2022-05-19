package com.ssafy.happyhouse.model.service;
import java.util.List;

import com.ssafy.happyhouse.model.dto.HouseInfo;

public interface HouseInfoService {
	List<HouseInfo> selectGuDong() throws Exception;
	List<HouseInfo> selectGu() throws Exception;
	List<HouseInfo> selectDong() throws Exception;
	HouseInfo selectDetail(int aptCode) throws Exception;


}
 