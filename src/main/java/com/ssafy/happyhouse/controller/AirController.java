package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.service.AirService;

@RestController
@RequestMapping("/air")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class AirController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private AirService service;

	// 지역구에 맞는 2015~~2022 미세먼지 조회 
	@GetMapping("/{gugunName}")
	public ResponseEntity<?> selectGu(@PathVariable("gugunName") String gugunName) {

		try {
			return new ResponseEntity<List>(service.selectGu(gugunName), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	// 지역구별로 2015~2020 미세먼지 평균값 적은 순
	@GetMapping("/avg")
	public ResponseEntity<?> avgResult() {

		try {
			return new ResponseEntity<List>(service.avgResult(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
