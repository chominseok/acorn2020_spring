package test.main2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.Remocon;

public class MainClass02 {
	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("test/main2/init.xml");
		
		Remocon r = cxt.getBean(Remocon.class);
		
		useRemocon(r);
	}
	
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
}
