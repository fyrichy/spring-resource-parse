package com.richy.spring.model;

public class Teacher {
	private String name;
	private Integer age;
	private String description;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", age=" + age + ", description=" + description + "]";
	}
}
