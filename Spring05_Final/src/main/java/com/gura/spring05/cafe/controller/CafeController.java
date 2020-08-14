package com.gura.spring05.cafe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.cafe.dto.CafeDto;
import com.gura.spring05.cafe.service.CafeService;

@Controller
public class CafeController {
	@Autowired
	private CafeService cafeService;
	
	@RequestMapping("/cafe/list")
	public ModelAndView getList(ModelAndView m, HttpServletRequest request) {
		cafeService.getList(request);
		m.setViewName("cafe/list");
		return m;
	}
	
	@RequestMapping("/cafe/detail")
	public ModelAndView detail(HttpServletRequest request, ModelAndView m ) {
		cafeService.getDetail(request);
		m.setViewName("cafe/detail");
		return m;
	}
	
	@RequestMapping("/cafe/private/insertform")
	public ModelAndView insertFomr(ModelAndView m) {
		
		m.setViewName("cafe/private/insertform");
		return m;
	}
	
	@RequestMapping("/cafe/private/insert")
	public ModelAndView insert(ModelAndView m, CafeDto dto, HttpServletRequest request) {
		String id = (String)request.getSession().getAttribute("id");
		dto.setWriter(id);
		
		cafeService.insert(dto);
		m.setViewName("cafe/private/insert");
		return m;
	}
	
	@RequestMapping("/cafe/private/delete")
	public String delete(HttpServletRequest request) {
		cafeService.delete(request);
		return "cafe/private/delete";
	}
	
	@RequestMapping("/cafe/private/updateform")
	public ModelAndView updateForm(ModelAndView m, CafeDto dto) {
		cafeService.updateForm(dto, m);
		
		m.setViewName("cafe/private/updateform");
		return m;
	}
	
	@RequestMapping("/cafe/private/update")
	public String update(CafeDto dto) {
		cafeService.update(dto);
		
		return "cafe/private/update";
	}
}
