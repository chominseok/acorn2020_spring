package minseok.test.test01.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import minseok.test.test01.test.Dto.TestDto;
import minseok.test.test01.test.Service.TestService;

@Controller
public class TestController {
	@Autowired
	private TestService testService;
	
	@RequestMapping("/test")
	public ModelAndView getList(ModelAndView m){
		List<TestDto> list = testService.getList();
		m.addObject("list", list);
		m.setViewName("test");
		return m;
	}
}
