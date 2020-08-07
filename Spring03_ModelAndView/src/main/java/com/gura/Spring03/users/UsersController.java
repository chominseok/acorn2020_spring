package com.gura.Spring03.users;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsersController {
	@RequestMapping("/users/signup_form.do")
	public String signup_form() {
		//수행 할 비지니스 로직이 없을 경우가 있다.
		
		//view page 만 리턴
		return "users/signup_form";
	}
	
	
	@RequestMapping("/users/signup.do")
	public String signup(HttpServletRequest req) {
		//수행 할 비지니스 로직이 없을 경우가 있다.
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		System.out.println(id+" || "+pwd);
		//view page 만 리턴
		return "users/signup";
	}
	
	@RequestMapping("/users/signup2.do")
	public String signup2(@RequestParam String id, @RequestParam String pwd) {
		//수행 할 비지니스 로직이 없을 경우가 있다.
		System.out.println(id+" || "+pwd);
		/*
		 * @RequestParam 어노테이션과 함께 메소드의 인자를 선언하면
		 * 요청 파라미터가 자동추출되어서 전달된다. >>> 어노테이션 생략 가능
		 * 
		 * <=get 방식의 name value>
		 * form 요소의 name value와 해당 메소드의 인자 value가 같아야한다.
		 * ex)   name = "id" : String id
		 * 		 num = " num" : int num  >>> Integer.ParseInt("num")을 
		 * 											자동적으로 해줌
		 * */
		return "users/signup";
	}
	
	@RequestMapping("/users/signup3.do")
	public String signup3(@ModelAttribute UsersDto dto) {
		/*
		 * @ModelAttribute 어노테이션과 함께 dto를 선언하면
		 * 전송된 파라미터가 추출되고 dto에 담겨서 전달된다. >> 어노테이션 생략 가능
		 * 
		 * <=get 방식의 name value>
		 * form 요소의 name value와 dto의 필드명이 같아야한다.
		 * */
		System.out.println(dto.getId()+" || "+dto.getPwd());
		return "users/signup";
	}
}
