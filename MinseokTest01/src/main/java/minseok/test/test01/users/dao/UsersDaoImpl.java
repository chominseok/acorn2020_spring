package minseok.test.test01.users.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import minseok.test.test01.users.dto.UsersDto;

@Repository
public class UsersDaoImpl implements UsersDao{
	@Autowired
	private SqlSession session;
	
	@Override
	public boolean checkId(String inputId) {
		String checkId = session.selectOne("users.checkId", inputId);
		if(checkId == null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public void signup(UsersDto dto) {
		session.insert("users.signup", dto);
	}
}
