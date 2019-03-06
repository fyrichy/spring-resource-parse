package com.richy.spring.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Integer age;
	private String description;
	public String getName() {
		return name;
	}
	public User(String name, Integer age, String description) {
		super();
		this.name = name;
		this.age = age;
		this.description = description;
	}
	
	
	
	public User() {
		super();
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
		return "User [name=" + name + ", age=" + age + ", description=" + description + "]";
	}
	
	
	
}
