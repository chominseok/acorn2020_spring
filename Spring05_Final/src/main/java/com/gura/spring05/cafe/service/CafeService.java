package com.gura.spring05.cafe.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.cafe.dto.CafeDto;

public interface CafeService {
	public void getList(HttpServletRequest request);
	public void getDetail(HttpServletRequest request);
	public void insert(CafeDto dto);
	public void delete(HttpServletRequest request);
	public void updateForm(CafeDto dto, ModelAndView m);
	public void update(CafeDto dto);
}