package com.gura.spring02;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FortuneController {

	@RequestMapping("/fortune.nhn")
	/*
	 * HttpServletRequest or Respone or HttpSession 객체가 필요하면
	 * 메소드의 인자에 선언해 놓으면 자동으로 실행시점에 참조값이 전달된다.
	 * */
	public String fortune(HttpServletRequest req) {
		//1.오늘의 운세를 얻어오는 비지니스 로직을 처리한다.
		String fortuneToday = "동쪾으로 가면 귀인을 만나요";
		
		//2.로직 처리결과 데이터(model)을 request 영역에 담는다.
		req.setAttribute("fortuneToday", fortuneToday);
		
		//3.view 페이지(jsp)로 forward 한 뒤 응답한다.
		return "fortune";
	}
}
