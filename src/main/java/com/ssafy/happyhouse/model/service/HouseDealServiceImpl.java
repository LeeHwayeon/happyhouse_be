package com.ssafy.happyhouse.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.HouseDealDto;
import com.ssafy.happyhouse.model.dto.NoticeDto;
import com.ssafy.happyhouse.model.mapper.HouseDealMapper;

@Service
public class HouseDealServiceImpl implements HouseDealService {

	@Autowired
	private HouseDealMapper mapper;

	@Override
	public List<HouseDealDto> selectSidoApt(String sidocode) throws Exception {
		return mapper.selectSidoApt(sidocode);
	}

	@Override
	public Map<String, Object> selectSidoGugunApt(String guguncode, int buildyear, int aptprice, int page)
			throws Exception {
		System.out.println("값 : " + page + "/" + guguncode + "/" + buildyear + "/" + aptprice);
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("page", page);
		String ap = aptprice+"";

		int startPage = (page - 1) / 10 * 10 + 1; // 11~20 모두 11페이지가 첫번째임
		result.put("startPage", startPage);
		System.out.println("totalpage : " + mapper.selectSidototal(guguncode, buildyear, ap , page));
		
		
		int totalCount = mapper.selectSidototal(guguncode, buildyear, ap , page);
		System.out.println("totalCount : " + totalCount);
		int totalPage = totalCount / 10; // 한 페이지당 게시글 10개
		if (totalCount % 10 > 0) { // 게시글이 56개이면 56/10 = 5페이진데 한페이지 더 필요함
			totalPage++;
		}
		result.put("totalPage", totalPage);

		int endPage = startPage + 9; // 현재 페이지18인 경우 하단 페이지는 11~20
		if (endPage > totalPage) { // 만약 총 페이지 수는 37인데 위에서 더한 endPage는 40임 그래서 총 페이지보다 endPage가 더 크면 endPage를 총
									// 페이지로
			endPage = totalPage;
		}
		result.put("endPage", endPage);

		List<HouseDealDto> housedealList = mapper.selectSidoGugunApt(guguncode, buildyear, ap,
				(page - 1) * 10);
		result.put("housedealList", housedealList);
		System.out.println(housedealList);

		return result;

	}

	@Override
	public List<HouseDealDto> selectDongApt(String dongcode) throws Exception {
		return mapper.selectDongApt(dongcode);
	}

	@Override
	public List<HouseDealDto> selectAptname(String aptname, String guguncode) throws Exception {
		return mapper.selectAptname(aptname, guguncode);
	}

	@Override
	public List<HouseDealDto> selectApt(String dongcode, String aptname) throws Exception {
		return mapper.selectApt(dongcode, aptname);
	}

}
