package minseok.test.test01.test.Service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import minseok.test.test01.test.Dto.TestDto;

public interface TestService {
	public List<TestDto> getList();
}
