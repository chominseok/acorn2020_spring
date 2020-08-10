package com.gura.Spring04.todo.service;

import org.springframework.web.servlet.ModelAndView;

import com.gura.Spring04.todo.dto.TodoDto;


public interface TodoService {
	public void addTodo(TodoDto dto);
	public void updateTodo(TodoDto dto);
	public void deleteTodo(int num);
	public void getTodo(int num, ModelAndView m);
	public void getListTodo(ModelAndView m);
}
