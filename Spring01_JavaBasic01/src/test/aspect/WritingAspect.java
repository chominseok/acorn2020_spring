package test.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 * Aspect : 공통 관심사 (횡단 관심사)
 * -핵심 비즈니스 로직(핵심관심)과는 상관없는 공통관심사(횡단관심)를 따로 작성한다.
 * */
@Aspect
@Component
public class WritingAspect {
	//메소드가 수행되기 바로 이전에 적용될 수 있도록 설정하는 어노테이션
	@Before("execution(void write*())") 
	//return type이 void 이고 write1에 적용시키겠다는 의미
	public void prepare() {
		System.out.println("pen을 준비해요");
	}
	
	@After("execution(void write*())")
	public void end() {
		System.out.println("닷 사용한 pen을 마무리 해요.");
	}
	
	
	//before, after는 단독임, ex) 인자 전달 x
}

/*
 * 	-Aspectj Expression
 * 					..은 인자가 몇개든 상관 x
 * 	1. execution(* *(..)) => 접근 가능한 모든 메소드가 
 * 	   point cut >> aop를 적용시킨 위치
 * 	2. execution(* test.service.*.*(..)) 
 * 		=> test.service 패키지의 모든 메소드 point cut
 * 	3. execution(void insert*(..))
 * 		=>리턴 type 은 void 이고 메소드명이 
 * 		insert 로 시작하는 모든 메소드가 point cut
 * 	4. execution(* delete*(*))
 * 		=> 메소드 명이 delete 로 시작하고 인자로 1개 전달받는 
 *      메소드가 point cut (aop 가 적용되는 위치)
 * 	5. execution(* delete*(*,*))
 * 		=> 메소드 명이 delete 로 시작하고 인자로 2개 전달받는 
 *      메소드가 point cut (aop 가 적용되는 위치)
 *  6.execution(String update*(Integer,*))
 *  string type의 update이름을 가진 모든 메소드 + 인자로 int와 아무거나1나 총 2개 가진 녀석들
 */