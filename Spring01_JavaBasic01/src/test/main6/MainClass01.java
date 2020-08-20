package test.main6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.util.TestUtil;

public class MainClass01 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test/main6/init.xml");
		
		TestUtil tu = ctx.getBean(TestUtil.class);
		
		tu.test1();
		tu.test2();
		tu.test3();
	}
}
