package minseok.test.test01.users.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import minseok.test.test01.users.dto.UsersDto;
import minseok.test.test01.users.service.UsersService;

@Controller
public class UsersController {
	@Autowired
	private UsersService usersService;
	
	@RequestMapping("/users/signup_form")
	public String signupForm() {
		return "users/signup_form";
	}
	
	@ResponseBody
	@RequestMapping("/users/checkId")
	public Map<String, Object> checkId(@RequestParam String inputId){
		Map<String, Object> map = new HashMap<String, Object>();
		usersService.checkId(inputId);
		return map;
	}
	
	@RequestMapping("/users/signup")
	public String signup(UsersDto dto) {
		usersService.signup(dto);
		return "users/signup";
	}
}
