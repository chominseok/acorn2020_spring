package com.gura.spring02;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FriendController {
	
	@RequestMapping("/friend")
	public String friend(HttpServletRequest req) {
		List<String> list = new ArrayList<String>();
		list.add("강아지");
		list.add("원숭이");
		list.add("사자");
		list.add("호랑이");
		
		req.setAttribute("list", list);
		
		return "friend";
	}
}
