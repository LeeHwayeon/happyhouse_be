package com.ssafy.happyhouse.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.service.HouseDealService;

@RestController
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/housedeal")
public class HouseDealController {

	@Autowired
	private HouseDealService service;

	@GetMapping("/sidogugun/{guguncode}/buildyear/{buildyear}/aptprice/{aptprice}")
	public ResponseEntity<?> selectSidoGugunApt(@RequestParam(value = "p", defaultValue = "1") int page,
			@PathVariable("guguncode") String guguncode, @PathVariable("buildyear") int buildyear,
			@PathVariable("aptprice") String aptprice) {
		System.out.println("컨트롤러" + page + "/" + guguncode + "/" + buildyear + "/" + aptprice + "/");

		int ap = 0;
		if (aptprice.contains(".")) {
			ap = Integer.parseInt(aptprice.replace(".", "")) * 1000;
		} else {
			ap = Integer.parseInt(aptprice) * 10000;
		}
		try {
			return new ResponseEntity<Map<String, Object>>(service.selectSidoGugunApt(guguncode, buildyear, ap, page),
					HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/dong/{dongcode}/buildyear/{buildyear}/aptprice/{aptprice}")
	public ResponseEntity<?> selectDongApt(@RequestParam(value = "p", defaultValue = "1") int page,
			@PathVariable("dongcode") String dongcode, @PathVariable("buildyear") int buildyear,
			@PathVariable("aptprice") String aptprice) {
		System.out.println("컨트롤러" + page + "/" + dongcode + "/" + buildyear + "/" + aptprice + "/");

		int ap = 0;
		if (aptprice.contains(".")) {
			ap = Integer.parseInt(aptprice.replace(".", "")) * 1000;
		} else {
			ap = Integer.parseInt(aptprice) * 10000;
		}
		try {
			return new ResponseEntity<Map<String, Object>>(service.selectDongApt(dongcode, buildyear, ap, page),
					HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/guguncode/{guguncode}/buildyear/{buildyear}/aptprice/{aptprice}/aptname/{aptname}")
	public ResponseEntity<?> selectAptname(@RequestParam(value = "p", defaultValue = "1") int page,
			@PathVariable("guguncode") String guguncode, @PathVariable("buildyear") int buildyear,
			@PathVariable("aptprice") String aptprice, @PathVariable("aptname") String aptname) {
		System.out.println("컨트롤러" + page + "/" + guguncode + "/" + buildyear + "/" + aptprice + "/");

		int ap = 0;
		if (aptprice.contains(".")) {
			ap = Integer.parseInt(aptprice.replace(".", "")) * 1000;
		} else {
			ap = Integer.parseInt(aptprice) * 10000;
		}
		try {
			return new ResponseEntity<Map<String, Object>>(
					service.selectAptname(guguncode, buildyear, ap, page, aptname), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/dongcode/{dongcode}/buildyear/{buildyear}/aptprice/{aptprice}/aptname/{aptname}")
	public ResponseEntity<?> selectApt(@RequestParam(value = "p", defaultValue = "1") int page,
			@PathVariable("dongcode") String dongcode, @PathVariable("buildyear") int buildyear,
			@PathVariable("aptprice") String aptprice, @PathVariable("aptname") String aptname) {
		System.out.println("컨트롤러" + page + "/" + dongcode + "/" + buildyear + "/" + aptprice + "/");

		int ap = 0;
		if (aptprice.contains(".")) {
			ap = Integer.parseInt(aptprice.replace(".", "")) * 1000;
		} else {
			ap = Integer.parseInt(aptprice) * 10000;
		}
		try {
			return new ResponseEntity<Map<String, Object>>(service.selectApt(dongcode, buildyear, ap, page, aptname),
					HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/detail/{aptCode}")
	public ResponseEntity<?> selectDetail(@PathVariable("aptCode") long aptCode) {
		try {
			return new ResponseEntity<List>(service.selectDetail(aptCode), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/deal10")
	public ResponseEntity<?> selectDeal() {
		try {
			return new ResponseEntity<List>(service.selectDeal(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
