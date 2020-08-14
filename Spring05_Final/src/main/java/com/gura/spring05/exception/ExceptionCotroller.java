package com.gura.spring05.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//bean이 됨
@ControllerAdvice
public class ExceptionCotroller {
	//@ExceptionHandler() 괄호안의 타입의 exception이 발생하게 되면 실행순서가 여기로 들어온다.
	//예시  >>> throw new NotDeleteException("가세요 ㅎㅎ");
	@ExceptionHandler(NotDeleteException.class)
	public ModelAndView notDelete(NotDeleteException nde) {
		ModelAndView m = new ModelAndView();
		m.addObject("exception", nde);   // <<NotDeleteException 클래스의 message가 들어온다.
		m.setViewName("error/info");
		
		return m;
	}
}
