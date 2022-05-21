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

import com.ssafy.happyhouse.model.service.HouseDealService;

@RestController
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/housedeal")
public class HouseDealController {

	@Autowired
	private HouseDealService service;

	@GetMapping("/sidogugun/{guguncode}")
	public ResponseEntity<?> selectSidoGugunApt(@PathVariable("guguncode") String guguncode) {
		try {
			return new ResponseEntity<List>(service.selectSidoGugunApt(guguncode), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/dong/{dongcode}")
	public ResponseEntity<?> selectDongApt(@PathVariable("dongcode") String dongcode) {
		try {
			return new ResponseEntity<List>(service.selectDongApt(dongcode), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/aptname/{aptname}/guguncode/{guguncode}")
	public ResponseEntity<?> selectAptname(@PathVariable("aptname") String aptname,
			@PathVariable("guguncode") String guguncode) {
		try {
			return new ResponseEntity<List>(service.selectAptname(aptname, guguncode), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value= {"/aptname/{aptname}/dongcode/{dongcode}"})
	public ResponseEntity<?> selectApt(@PathVariable("aptname") String aptname,
			@PathVariable("dongcode") String dongcode) {
		try {
			return new ResponseEntity<List>(service.selectApt(dongcode, aptname), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
