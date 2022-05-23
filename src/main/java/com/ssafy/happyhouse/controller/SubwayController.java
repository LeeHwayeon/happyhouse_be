package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.service.SubwayService;

@RestController
@RequestMapping("/subway")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class SubwayController {
	@Autowired
	private SubwayService service;

	@GetMapping
	public ResponseEntity<?> selectListAll() {
		try {
			return new ResponseEntity<List>(service.selectListAll(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
