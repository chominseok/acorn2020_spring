package com.gura.Spring04.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.Spring04.member.dto.MemberDto;

@Controller
public class MemberController {	
	
	@RequestMapping("/member/insert")
	public ModelAndView insert(MemberDto dto) {
		return null;
	}
}
