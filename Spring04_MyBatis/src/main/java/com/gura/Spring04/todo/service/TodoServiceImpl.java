package com.gura.Spring04.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.Spring04.todo.dao.TodoDao;
import com.gura.Spring04.todo.dto.TodoDto;

@Service
public class TodoServiceImpl implements TodoService{
	@Autowired
	private TodoDao dao;
	
	@Override
	public void addTodo(TodoDto dto) {
		dao.insert(dto);
	}

	@Override
	public void updateTodo(TodoDto dto) {
		dao.update(dto);
	}

	@Override
	public void deleteTodo(int num) {
		dao.delete(num);
	}

	@Override
	public void getTodo(int num, ModelAndView m) {
		TodoDto dto = dao.getData(num);
		m.addObject("dto", dto);
	}

	@Override
	public void getListTodo(ModelAndView m) {
		List<TodoDto> list = dao.getList();
		m.addObject("list", list);
	}
	
//	@Override
//	public void addTodo(TodoDto dto) {
//		dao.insert(dto);
//	}
//
//	@Override
//	public void updateTodo(TodoDto dto) {
//		dao.update(dto);
//	}
//
//	@Override
//	public void deleteTodo(int num) {
//		dao.delete(num);
//	}
//
//	@Override
//	public void getTodo(int num, ModelAndView m) {
//		TodoDto dto = dao.getData(num);
//		m.addObject("dto", dto);
//	}
//
//	@Override
//	public void getListTodo(ModelAndView m) {
//		List<TodoDto> list = dao.getList();
//		m.addObject("list", list);
//	}
}
