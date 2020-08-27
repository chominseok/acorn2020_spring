package minseok.test.test01.users.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import minseok.test.test01.users.dao.UsersDao;
import minseok.test.test01.users.dto.UsersDto;

@Service
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UsersDao usersDao;
	
	@Override
	public Map<String, Object> checkId(String inputId) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean checkId = usersDao.checkId(inputId);
		map.put("isValid", checkId);
		return map;
	}

	@Override
	public void signup(UsersDto dto) {
		usersDao.signup(dto);
	}
}
