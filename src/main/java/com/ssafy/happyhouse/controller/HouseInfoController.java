package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.model.service.HouseInfoService;

@Controller
@RequestMapping("/houseinfo")
@CrossOrigin("*")
public class HouseInfoController {

	@Autowired
	private HouseInfoService service;

	// 아파트 거래가 리스트 조회에서 구,동 선택할 수 있도록
	@GetMapping("/list")
	@ResponseBody
	public Map<String, List> list() throws Exception {
		Map<String, List> map = new HashMap<String, List>();
		map.put("gugun", service.selectGu());
//		map.put("dong", service.selectDong());
		map.put("gudong", service.selectGuDong());
		return map;
	}

	// 아파트 거래가 리스트 화면에서 상세 화면으로
	@GetMapping("/detail/{aptCode}")
	public ModelAndView detail(@PathVariable int aptCode) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("houseDetail", service.selectDetail(aptCode));
		mv.setViewName("HouseInfo");
		return mv;
	}
}
