package com.ssafy.happyhouse.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.dto.SearchDto;
import com.ssafy.happyhouse.model.service.HouseDealService;

@RestController
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/housedeal")
public class HouseDealController {

	@Autowired
	private HouseDealService service;

	// 아파트 실거래가 조회 화면에서 구, 동 선택해서 검색 누르면 ajax로 데이터 뿌리기
	@PostMapping("/search")
	@ResponseBody
	public Map<String, List> houseList(@RequestBody SearchDto search) throws Exception {
//		public Map<String, List> houseList(@RequestParam(value = "dongName", required = false) String dongName,
//				@RequestParam(value = "aptName", required = false) String aptName) throws Exception {
		String dongName = search.getDongName();
		String aptName = search.getAptName();
		System.out.println("dongName : " + dongName.length());
		System.out.println("aptName : " + aptName.length());
		Map<String, List> map = new HashMap<String, List>();
		if (dongName.length() > 0 && aptName.length() == 0) { // 동 이름만 들어올때
			System.out.println("동이름만");
			map.put("houseList", service.selectDongDeal(dongName));

			List<String> avg = new ArrayList<String>();
			// 콤마 찍기
			DecimalFormat decFormat = new DecimalFormat("###,###");
			String str = decFormat.format(avg(service.selectDongDeal(dongName)));
			avg.add(str);

			map.put("avg", avg);
			return map;
		} else if (dongName.length() == 0 && aptName.length() > 0) { // 아파트 이름만 들어올때
			System.out.println("아파트 이름만");
			System.out.println(service.selectAptDeal(aptName));
			map.put("houseList", service.selectAptDeal(aptName));
			return map;
		}
		System.out.println("동&아파트이름");
		System.out.println(service.selectDongAptName(dongName, aptName));
		map.put("houseList", service.selectDongAptName(dongName, aptName));

		List<String> avg = new ArrayList<String>();
		// 콤마 찍기
		DecimalFormat decFormat = new DecimalFormat("###,###");
		String str = decFormat.format(avg(service.selectDongAptName(dongName, aptName)));
		avg.add(str);

		map.put("avg", avg);
		return map;
	}

	public int avg(List<HouseDeal> h) {
		int sum = 0;
		int size = h.size();
		for (int i = 0; i < size; i++) {
			int deal = Integer.parseInt(h.get(i).getDealAmount().replace(",", "").trim());
			sum += deal;
		}
		if (size == 0)
			return 0;
		return sum / size;
	}

}
