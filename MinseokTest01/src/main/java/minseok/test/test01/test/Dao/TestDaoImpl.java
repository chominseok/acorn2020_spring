package minseok.test.test01.test.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import minseok.test.test01.test.Dto.TestDto;

@Repository
public class TestDaoImpl implements TestDao{
	@Autowired
	private SqlSession session;
	
	@Override
	public List<TestDto> getList() {
		
		return session.selectList("test.getList");
	}
}
