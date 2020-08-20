package test.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {
	
	@Before("execution(void test1())")
	public void testAspect() {
		System.out.println("@Before로 테스트 준비합니다.");
	}
	
	@Before("execution(void test2())")
	public void testAspect2() {
		System.out.println("@Before로 테스트는 준비하는데 귀찮 ㅎㅎ");
	}
	
	@Before("execution(void test3())")
	public void testAspect3() {
		System.out.println("아멀랑 니가 알아서 하셈 ㅎㅎㅎㅎ");
	}
	
	@After("execution(void test1())")
	public void testAspect4() {
		System.out.println("테스트 잘 마침!");
	}
	
	@After("execution(void test2())")
	public void testAspect5() {
		System.out.println("테스트 애매함 ㅎㅎㅎ");
	}
	
	@After("execution(void test3())")
	public void testAspect6() {
		System.out.println("테스트 망침!!!");
	}
}
