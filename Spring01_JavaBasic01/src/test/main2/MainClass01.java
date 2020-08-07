package test.main2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.Weapon;

public class MainClass01 {
	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("test/main2/init.xml");
		
		Weapon w = cxt.getBean(Weapon.class);
		
		useWeapon(w);
	}
	
	public static void useWeapon(Weapon w) {
		w.attack();
	}
}
