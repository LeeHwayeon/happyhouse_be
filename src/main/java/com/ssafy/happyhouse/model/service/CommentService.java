package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.CommentDto;

public interface CommentService {
	List<CommentDto> list(int nno);

	boolean create(CommentDto commentDto);

	boolean modify(CommentDto commentDto);

	boolean delete(int cno);

}