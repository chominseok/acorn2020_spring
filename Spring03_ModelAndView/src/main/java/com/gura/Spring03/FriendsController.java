package com.gura.Spring03;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FriendsController {
	
	@RequestMapping("/friends.do")
	public String friends(HttpServletRequest req) {
		List<String> list = new ArrayList<String>();
		
		list.add("김구라");
		list.add("해골");
		list.add("원숭이");
		req.setAttribute("list", list);
		
		return "friends";
	}
	
	//맵핑으로 가져와서 return (view page)로 보여준다
	// view page는 보여주기(응답)이기 때문에 겹쳐도 되지만 맵핑은 겹치면 오류가 뜬다.
	
	@RequestMapping("/friends2.do")
	public ModelAndView friends2() {
		List<String> list = new ArrayList<String>();
		
		list.add("김구라");
		list.add("해골");
		list.add("원숭이");
		
		//model과 view 페이지 정보를 함께 담을 수 있는 ModelAndView객체 생성
		
		ModelAndView mView = new ModelAndView();
		mView.addObject("list", list);  //데이터(모델) >> 내부적으로 request에 담아준다.
		mView.setViewName("friends");   //view page
		
		return mView;
	}
	
	//ModelAndView는 인자로 생성할 수도 있따.
	@RequestMapping("/friends3.do")
	public ModelAndView friends3(ModelAndView mView) {
		List<String> list = new ArrayList<String>();
		
		list.add("김구라");
		list.add("해골");
		list.add("원숭이");
		
		mView.addObject("list", list);  //데이터(모델) >> 내부적으로 request에 담아준다.
		mView.setViewName("friends");   //view page
		
		return mView;
	}
	
	@RequestMapping("/delete.do")
	public String delete() {
		//예시
		System.out.println("친구 정보를 삭제합니다.");
		
		//삭제 후 친구 목록 보기로 redirect 이동
		
		return "redirect:/friends.do";
	}
	
	@RequestMapping("/delete2.do")
	public ModelAndView delete2(ModelAndView mView) {
		//예시
		System.out.println("친구 정보를 삭제합니다.");
		
		//삭제 후 친구 목록 보기로 redirect 이동
		
		mView.setViewName("redirect:/friends.do");
		return mView;
	}
}
