package test.util;

import org.springframework.stereotype.Component;

@Component
public class Messanger {
	public void sendGreeting(String msg) {
		System.out.println("전달된 오늘의 인사 : "+msg);
	}
	
	public String getMessage() {
		System.out.println("getMessage() 메소드가 수행됩니다.");
		
		return "공부하자!";
	}
}
