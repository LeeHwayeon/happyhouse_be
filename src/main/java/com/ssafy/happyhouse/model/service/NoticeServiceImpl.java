package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.NoticeDto;
import com.ssafy.happyhouse.model.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper mapper;

	@Override
	public int write(NoticeDto notice) throws SQLException {
		System.out.println("before insert nno : " + notice.getNno());
		
		System.out.println("after insert nno : " + notice.getNno());
		return mapper.insert(notice);
	}

	@Override
	public Map<String, Object> makePage(int page) throws SQLException {
		// 현재 페이지, 하단 시작 페이지, 하단 끝 페이지, 게시글 목록, 총 페이지 수
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("page", page);

		int startPage = (page - 1) / 10 * 10 + 1; // 11~20 모두 11페이지가 첫번째임
		result.put("startPage", startPage);

//				int totalCount = template.getMapper(BoardMapper.class).selectTotalCount();
		int totalCount = mapper.selectTotalCount();
		int totalPage = totalCount / 10; // 한 페이지당 게시글 10개
		if (totalCount % 10 > 0) { // 게시글이 56개이면 56/10 = 5페이진데 한페이지 더 필요함
			totalPage++;
		}
		result.put("totalPage", totalPage);

		int endPage = startPage + 9; // 현재 페이지18인 경우 하단 페이지는 11~20
		if (endPage > totalPage) { // 만약 총 페이지 수는 37인데 위에서 더한 endPage는 40임 그래서 총 페이지보다 endPage가 더 크면 endPage를 총
									// 페이지로
			endPage = totalPage;
		}
		result.put("endPage", endPage);

		List<NoticeDto> noticeList = mapper.selectList((page - 1) * 10, 10);
		result.put("noticeList", noticeList);

		return result;
	}
	
	@Override
	public Map<String, Object> search(int page, String ntitle) throws SQLException {
		// 현재 페이지, 하단 시작 페이지, 하단 끝 페이지, 게시글 목록, 총 페이지 수
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("page", page);

		int startPage = (page - 1) / 10 * 10 + 1; // 11~20 모두 11페이지가 첫번째임
		result.put("startPage", startPage);

//				int totalCount = template.getMapper(BoardMapper.class).selectTotalCount();
		int totalCount = mapper.searchTotalCount(ntitle);
		int totalPage = totalCount / 10; // 한 페이지당 게시글 10개
		if (totalCount % 10 > 0) { // 게시글이 56개이면 56/10 = 5페이진데 한페이지 더 필요함
			totalPage++;
		}
		result.put("totalPage", totalPage);

		int endPage = startPage + 9; // 현재 페이지18인 경우 하단 페이지는 11~20
		if (endPage > totalPage) { // 만약 총 페이지 수는 37인데 위에서 더한 endPage는 40임 그래서 총 페이지보다 endPage가 더 크면 endPage를 총
									// 페이지로
			endPage = totalPage;
		}
		result.put("endPage", endPage);

		List<NoticeDto> noticeList = mapper.searchList((page - 1) * 10, 10, ntitle);
		result.put("noticeList", noticeList);

		return result;
	}

	@Override
	public Map<String, Object> read(int nno/*, String userInfo*/) throws SQLException {
		NoticeDto notice = mapper.selectOne(nno);

//		if (notice != null && !notice.getNwriter().equals(userInfo)) {
//			mapper.updateReadCount(nno); // 조회수 업데이트
//			notice = mapper.selectOne(nno);
//		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("board", notice); // 현재 읽는 게시글 내용
//		map.put("files", fdao.selectList(bno)); // 해당 게시글에 첨부된 파일 목록

		return map;
	}

	@Override
	public int delete(int nno) throws SQLException {
		return mapper.Delete(nno);
	}

	@Override
	public int update(NoticeDto notice) throws SQLException {
		
		return mapper.update(notice);
	}
	
	

}
