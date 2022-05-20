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

import com.ssafy.happyhouse.model.service.SidoGugunDongCodeService;

@RestController
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/code")
public class SidoGugunDongCodeController {

	@Autowired
	private SidoGugunDongCodeService service;

	@GetMapping
	public ResponseEntity<?> selectSido() {
		try {
			return new ResponseEntity<List>(service.selectSido(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/gugun/{sidocode}")
	public ResponseEntity<?> selectGugun(@PathVariable String sidocode) {
		try {
			return new ResponseEntity<List>(service.selectGugun(sidocode), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/dong/{guguncode}")
	public ResponseEntity<?> selectDong(@PathVariable String guguncode) {
		try {
			System.out.println(service.selectDong(guguncode));
			return new ResponseEntity<List>(service.selectDong(guguncode), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
