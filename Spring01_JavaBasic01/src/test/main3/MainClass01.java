package test.main3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.auto.Car;
import test.auto.Sedan;



public class MainClass01 {
	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("test/main3/init.xml");
		
		//class로
		Car c1 = cxt.getBean(Car.class);
		c1.drive();
		Sedan s1 = cxt.getBean(Sedan.class);
		s1.showInfo();
	
		//id로    >>> 인터페이스가 아닌데 왜 캐스팅? >> object로 리턴되어서 
		Car c2 = (Car)cxt.getBean("car1");
		c2.drive();
		
		Sedan s2 = (Sedan)cxt.getBean("sedan1");
		s2.showInfo();
	}
}
