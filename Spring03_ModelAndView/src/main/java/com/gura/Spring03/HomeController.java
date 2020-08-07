package com.gura.Spring03;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//component scan을 했을 때 homecontroller 객체가 생성이 되고 spring이 관리한다.
//spring이 관리한다는 의미는 spring bean 컨테이너에서 관리되는 객체가 된다는 의미이다.
@Controller
public class HomeController {
	//home.do 요청이 들어왔을 때 이 메소드로 요청을 처리하게 된다.
	@RequestMapping("/home.do")
	public String home(HttpServletRequest req) {
		//공지사항 목록이라고 가정하자 데이터들을 모델이라고 한다.
		List<String> list = new ArrayList<String>();
		
		list.add("장마철이네요");
		list.add("어쩌구...");
		list.add("저쩌구...");
		list.add("블라블라~~");
		
		req.setAttribute("list", list);
		//redirect로 이동하면 request 영역에 담은 내용은 삭제된다.
		
		
		//맵핑이 겹치면 오류가 뜬다.
		return "home";
	}
	
	//맵핑과 응답 페이지가 다른 코드에서도 중복되면 오류가 뜬다.
	
//	@RequestMapping("/friends.do")
//	public String friends(HttpServletRequest req) {
//		//공지사항 목록이라고 가정하자 데이터들을 모델이라고 한다.
//		List<String> list2 = new ArrayList<String>();
//		
//		list2.add("장마철이네요");
//		list2.add("어쩌구...");
//		list2.add("저쩌구...");
//		list2.add("블라블라~~");
//		
//		req.setAttribute("list2", list2);
//		//redirect로 이동하면 request 영역에 담은 내용은 삭제된다.
//		
//		
//		//리턴하는 문자열은 view 페이지의 위치를 알려주는 것이다.
//		return "friends";
//	}
	
}
