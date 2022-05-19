package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.CommentDto;
import com.ssafy.happyhouse.model.service.CommentService;

@Controller
@RequestMapping("/comment")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
public class CommentController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";	
	
	@Autowired
	private CommentService service;
	
	@PostMapping("/write")
	public ResponseEntity<String> wirte(@RequestBody CommentDto comment){
		System.out.println(comment);
		if (service.create(comment)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{nno}")
	public ResponseEntity<List<CommentDto>> listComment(@PathVariable("nno") int nno) {
	        return new ResponseEntity<>(service.list(nno), HttpStatus.OK);
	}
	@DeleteMapping("/{cno}")
}