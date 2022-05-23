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

import com.ssafy.happyhouse.model.service.ParkService;

@RestController
@RequestMapping("/park")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class ParkController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private ParkService service;

	@GetMapping("/{dong}/lat/{lat}/lng/{lng}")
	public ResponseEntity<?> parklist(@PathVariable("dong") String dong, @PathVariable("lat") double lat,
			@PathVariable("lng") double lng) {
		System.out.println(dong);
		System.out.println(lat);
		System.out.println(lng);
		try {
			return new ResponseEntity<List>(service.selectList(dong, lat, lng), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
