package test.main;

import test.mypac.Weapon;
import test.mypac.WeaponImpl;
/*
 * ex) WeaponImpl은 Weapon에 의존하고있다. 따라서 weapon을 수정하게 되면  WeaponImpl도 수정해야한다.
 * 의존 관계를 낮추려면 implemnets를 잘활용하고
 * 필요한 객체는 new 하지 않는다.               >>> 도와주는게 spring framework (코드는 늘어나지만 유지보수 용이)
 * */
public class MainClass01 {
	public static void main(String[] args) {
		//Application의 무언가를 공격하는게 목적이라면 
		
		//목적 달성하기 위한 필요한 핵심 의존 객체를 직접 생성해서
		WeaponImpl w1 = new WeaponImpl();
		//메소드 호출해서 목적을 달성
		w1.attack();
		
		Weapon w2 = new WeaponImpl();
		w2.attack();
	}
}
