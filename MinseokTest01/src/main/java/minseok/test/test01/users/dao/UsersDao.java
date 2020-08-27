package minseok.test.test01.users.dao;

import java.util.Map;

import minseok.test.test01.users.dto.UsersDto;

public interface UsersDao {
	public boolean checkId(String id);
	
	public void signup(UsersDto dto);
}
