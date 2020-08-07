package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.Weapon;
import test.mypac.WeaponImpl;

/*
 * test.main 우클릭 new > other > spring > Spring bean configuration file 선택해서 xml 생성
 * */
public class MainClass02 {
	public static void main(String[] args) {
		//init.xml 문서를 로딩해서 spring이 생성할 객체는 생성해서 관리하도록 한다.
		ApplicationContext cxt = new ClassPathXmlApplicationContext("test/main/init.xml");
		//관리하고 있는 객체 중에서 id가 myWeapon인 객체의 참조값을 얻어와서
		//인터페이스 type으로 casting한다. >> 굳이 interface가 아니더라도 object로 리턴되어서 캐스팅 필요함
		Weapon w1 = (WeaponImpl)cxt.getBean("WeaponImpl");
		Weapon w2 = (Weapon)cxt.getBean("WeaponImpl");
		//기능사용
		w1.attack();
		w2.attack();
	}
}
