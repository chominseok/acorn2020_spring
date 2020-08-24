package test.main5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.util.Messanger;

public class MainClass02 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test/main5/intit.xml");
		
		Messanger m = ctx.getBean(Messanger.class);
		
		String msg = m.getMessage();
		System.out.println("msg : "+msg);
		
		m.sendGreeting("ㅎㅇㅎㅇ!");
		m.sendGreeting("바보");
	}
}
