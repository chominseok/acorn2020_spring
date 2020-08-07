package com.gura.Spring03.users;

public class UsersDto {
	private String id;
	private String pwd;

	public UsersDto() {}

	public UsersDto(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		System.out.println("setId 호출이요~~~~");
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		System.out.println("setPwd 호출이요~~~~");
		this.pwd = pwd;
	}
	
}
