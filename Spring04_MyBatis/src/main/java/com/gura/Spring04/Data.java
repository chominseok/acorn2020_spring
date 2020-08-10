package com.gura.Spring04;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "chominseok")
public class Data {
	private int num;
	private String name;
	
	public Data() {}
	
	public Data(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	public int getNum() {
		return num;
	}
	@XmlElement
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	
}
