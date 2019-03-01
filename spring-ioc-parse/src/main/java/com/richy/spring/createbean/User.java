package com.richy.spring.createbean;

public class User {

	private String id;
	private String name;
	
	public User() {
		System.out.println("User的无参构造方法...");
	}
	
	public User(String id,String name) {
		System.out.println("User的有参构造方法：id="+id+"：name="+name);
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
}
