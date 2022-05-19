package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.NoticeDto;
import com.ssafy.happyhouse.model.service.NoticeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/notice")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class NoticeController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private NoticeService service;

	@ApiOperation(value = "게시글 목록")
	@GetMapping("/ajax/list") // 동기요청 -> 비동기요청(@ResponseBody)
	public ResponseEntity<?> list(@RequestParam(value = "p", defaultValue = "1") int page) {
		try {
			return new ResponseEntity<Map<String, Object>>(service.makePage(page), HttpStatus.ACCEPTED);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "게시글 상세 보기")
	@GetMapping("/ajax/read/{nno}")
	public ResponseEntity<?> read(@PathVariable("nno") int nno /* HttpSession session */) {
		try {
			System.out.println(nno);
//			UserDto userDto = (UserDto) session.getAttribute("userinfo");
//			String userInfo = userDto.getUid();
//			System.out.println(userInfo);
			return new ResponseEntity<Map<String, Object>>(service.read(nno /* userInfo */), HttpStatus.ACCEPTED);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/write")
	public ResponseEntity<String> wirte(@RequestBody NoticeDto notice)
			throws IllegalStateException, IOException, SQLException {
		if (service.write(notice) > 0) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/delete/{nno}")
	public ResponseEntity<String> delete(@PathVariable("nno") int nno) throws Exception {
		if (service.delete(nno) > 0)
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);

		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@PostMapping("/ajax/update/{nno}")
	public String update(@RequestBody NoticeDto notice) throws SQLException {
		System.out.println(notice);
		if (service.update(notice) > 0) {
			return "게시글 수정이 완료되었습니다.";
		}
		return "게시글 수정에 실패했습니다.";
	}
	
	@ApiOperation(value = "게시글 목록")
	@GetMapping("/{keyword}") // 동기요청 -> 비동기요청(@ResponseBody)
	public ResponseEntity<?> search(@RequestParam(value = "p", defaultValue = "1") int page, @PathVariable("keyword") String ntitle) {
		try {
			return new ResponseEntity<Map<String, Object>>(service.search(page, ntitle), HttpStatus.ACCEPTED);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}