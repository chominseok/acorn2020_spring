package com.gura.Spring03.users;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@RequestMapping("/users/test.do")
	public String test() {
		return "users/test_form";
	}
	
	@RequestMapping("/users/signupTest.do")
	public String test1(HttpServletRequest req) {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		return "users/test";
	}
	
	@RequestMapping("/users/signupTest2.do")
	public String test2(@RequestParam String id, @RequestParam String pwd) {
		return "users/test";
	}
	
	@RequestMapping("/users/signupTest3.do")
	public ModelAndView test3(@ModelAttribute UsersDto dto) {
		System.out.println(dto.getId()+" || "+dto.getPwd());
		//해당 페이지에서만 dto에 setter를 호출하고 값은 dto 형식이 아닌 string으로 넘어가나? ㄴㄴ 들어감
		//dto = new UsersDto(dto.getId(), dto.getPwd());
		ModelAndView m = new ModelAndView();
		m.addObject("dto", dto);
		m.setViewName("users/test");
		
		return m;
	}
}
