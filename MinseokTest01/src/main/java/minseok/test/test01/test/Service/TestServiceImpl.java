package minseok.test.test01.test.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import minseok.test.test01.test.Dao.TestDao;
import minseok.test.test01.test.Dto.TestDto;

@Service
public class TestServiceImpl implements TestService{
	@Autowired
	private TestDao testDao;
	
	@Override
	public List<TestDto> getList() {
		List<TestDto> list = testDao.getList();
		return list;
	}
}
