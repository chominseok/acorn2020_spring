package minseok.test.test01.users.service;

import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import minseok.test.test01.users.dto.UsersDto;

public interface UsersService {
	public Map<String, Object> checkId(String id);
	
	public void signup(UsersDto dto);
}
