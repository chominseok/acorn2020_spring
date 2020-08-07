package com.gura.spring02;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//컨트롤러를 만들 때 사용하는 어노테이션
@Controller
public class HomeController {
	
	//해당 메소드가 어떤 요청을 처리할지 결정하는 어노테이션
	@RequestMapping("/home.nhn")   //맵핑에 .nhn은 생략 가능하다.
	public String home() {
		
		//forward 될 jsp 페이지의 위치를 리턴해준다.
		return "home";
		///WEB-INF/views" + "home" + ".jsp"
		// 자동적으로 앞 ,뒤 주소,형태가 디폴트로 설정되어있다. (appServlet/servlet-context.xml에 저장되어있음)
	}
}
