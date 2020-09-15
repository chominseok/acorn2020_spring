package com.gura.spring05.cafe.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.cafe.dto.CafeCommentDto;
import com.gura.spring05.cafe.dto.CafeDto;

public interface CafeService {
	public void getList(HttpServletRequest request);
	
	
	public void getDetail(HttpServletRequest request);
	
	
	public void insert(CafeDto dto);
	public void delete(int num, HttpServletRequest request);
	public void updateForm(CafeDto dto, ModelAndView m);
	public void update(CafeDto dto);
	public void saveComment(HttpServletRequest request); //댓글 저장
	public void deleteComment(HttpServletRequest req);
	public void updateComment(CafeCommentDto dto);
	public Map<String, Object> getList2(HttpServletRequest request);
}
