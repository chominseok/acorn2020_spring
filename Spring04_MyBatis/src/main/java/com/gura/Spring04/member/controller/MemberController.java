package com.gura.Spring04.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.Spring04.member.dao.MemberDao;
import com.gura.Spring04.member.dto.MemberDto;
import com.gura.Spring04.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;
											//.get으로 하면 post가 동작 x ,반대 적용
	//requestmapping 활용						//get방식 /member/xxxx 요청 처리
	//@RequestMapping(value = "/member/list" , method=RequestMethod.GET)
	@RequestMapping("/member/list")
	public ModelAndView list(ModelAndView m) {
//		ModelAndView m=new ModelAndView();  인자로 쓴 것과 같은 역할 명시만 해줄 수 있다.
		//회원 목록을 얻어온다.
		service.getListMember(m);

		m.setViewName("member/list");
		
		return m;
	}
	
	@RequestMapping("/member/insertform.do")
	public String insertform() {	
		//페이지만 이동하기 때문에 코드는 없음
		
		return "member/insertform";
	}
	
	@RequestMapping("/member/insert.do")
	public ModelAndView insert(@ModelAttribute MemberDto dto ) {	
		//회원을 추가하는 메소드
		service.addMember(dto);
		ModelAndView m = new ModelAndView();
		m.addObject("dto", dto);
		m.setViewName("member/insert");
		return m;
	}
	
	//@RequestParam(defaultValue = ) 으로 디폴트 값을 설정할 수도 있따.
	@RequestMapping("/member/delete.do")
	public String deleteTOform(@RequestParam int num) {	
		service.deleteMember(num);
		return "member/delete";
	}
	
	
	@RequestMapping("/member/update_form.do")
	public ModelAndView update_form(@RequestParam int num, ModelAndView m) {	
		//한명의 데이터를 가져와 정보를 보여준다.
		service.getMember(num, m);
		//자동으로 넘어가나?
		m.setViewName("/member/update_form");
		
		return m;
	}
	
	
	@RequestMapping("/member/update.do")
	public String update(@ModelAttribute MemberDto dto) {	
		service.updateMember(dto);
		return "/member/update";
	}
}
