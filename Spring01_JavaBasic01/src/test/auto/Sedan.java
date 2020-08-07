package test.auto;

public class Sedan {
	private String name;
	private int weight;
	private Engine engine;
	
	public void setEngine(Engine engine) {
		this.engine = engine;
		System.out.println("engine 호출?");
	}
	
	public void setName(String name) {
		this.name = name;
		System.out.println("name 호출?");
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
		System.out.println("weight 호출?");
	}
	
	public void showInfo() {
		if(engine == null) {
			System.out.println("엔진은 없음");
			System.out.println("세단의 이름은 : "+name+" 무게는 : "+weight);
		}else {
			System.out.println("세단의 이름은 : "+name+", 무게는 : "+weight);			
		}
	}
}
