package com.gura.Spring04.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.Spring04.todo.dto.TodoDto;
import com.gura.Spring04.todo.service.TodoService;

@Controller
public class TodoController {
	@Autowired
	private TodoService service;
	
	@RequestMapping("/todo/list")
	public ModelAndView getList(ModelAndView m) {
		service.getListTodo(m);
		m.setViewName("todo/list");
		return m;
	}
	
	@RequestMapping("/todo/insert_form")
	public String insert_form() {
		
		return "todo/insert_form";
	}
	
	@RequestMapping("/todo/insert")
	public String insert(TodoDto dto) {
		service.addTodo(dto);
		
		return "todo/insert";
	}

	@RequestMapping("/todo/update_form")
	public ModelAndView update_form(int num, ModelAndView m) {
		service.getTodo(num, m);
		m.setViewName("todo/update_form");
		return m;
	}
	
	@RequestMapping("/todo/update")
	public String update(TodoDto dto) {
		service.updateTodo(dto);
		
		return "todo/update";
	}
	
	@RequestMapping("/todo/delete")
	public String delete(int num) {
		service.deleteTodo(num);
		
		return "todo/delete";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@RequestMapping("/todo/list")
//	public ModelAndView list(ModelAndView m) {
//		service.getListTodo(m);
//		m.setViewName("todo/list");
//		return m;
//	}
//	
//	
//	@RequestMapping("/todo/insert_form")
//	public String insert_form() {
//		
//		return "todo/insert_form";
//	}
//	
//	@RequestMapping("/todo/insert")
//	public ModelAndView insert(TodoDto dto) {
//		service.addTodo(dto);
//		ModelAndView m = new ModelAndView();
//		m.addObject("dto", dto);
//		m.setViewName("todo/insert");
//		return m;
//	}
//	
//	@RequestMapping("/todo/delete")
//	public String delete(int num) {
//		service.deleteTodo(num);
//		return "todo/delete";
//	}	
//	
//	@RequestMapping("/todo/update_form")
//	public ModelAndView update_form(int num, ModelAndView m) {
//		service.getTodo(num, m);
//		m.setViewName("todo/update_form");
//		return m;
//	}
//	
//	@RequestMapping("/todo/update.do")
//	public String update(TodoDto dto) {
//		service.updateTodo(dto);
//
//		return "todo/update";
//	}
}
