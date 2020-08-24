package test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MessangerAspect {
	
	@Around("execution(void send*(..))")
	public void checkGreeting(ProceedingJoinPoint joinPoint) throws Throwable{
		//aop가 적용된 메소드 수행하기 이전에 해야할 작업  @before

		//메소드에 전달된 인자들 목록을 얻어내기
		Object[] args = joinPoint.getArgs();
		for(Object tmp : args) {
			//인자의 갯수만큼 반복문이 돈다. >> Object type이므로 원래 type으로 캐스팅 할 필요가 있다.
			if(tmp instanceof String) { //인자가 String type이면
				String msg = (String)tmp;
				System.out.println("aspect에서 읽어낸 내용 : " + msg);
				
				if(msg.contains("바보")) {
					System.out.println("바보는 금지된 단어입니다.");
					return; 
				}
			}
		}
		
		joinPoint.proceed();  //aop가 적영된 메소드 수행하기  호출하지 않으면 수행 x >> aspect 받은 메소드도 수행이 안됨
		
		//aop가 적용된 메소드 수행 이후 해야할 작업  @after
		System.out.println("proceed이후 작업 내용이 나오나??????");
	}
	
	@Around("execution(String get*())")
	public Object checkReturn(ProceedingJoinPoint jointPoint) throws Throwable {
		
		//aop가 적용된 메소드가 리턴하는 데이터 얻어내기
		Object obj = jointPoint.proceed();  //메소드를 수행하고 리턴값이 있으면 obj에 넣는다.
		
		//aop가 적용된 메소드가 리턴하는 데이터
		return obj;
	}
}
