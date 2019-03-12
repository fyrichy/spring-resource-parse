package com.richy.spring.model;

import java.io.Serializable;
import java.util.Date;

import com.richy.spring.annotation.ExcelField;

/**
 * @descrp：User
 * @author：FyRichy
 * @time：2019年3月12日下午3:37:43
 */
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String age;
	private String name;
	private String description;
	private Date birthDay;
	
	
	public User(String age, String name, String description,Date birthDay) {
		super();
		this.age = age;
		this.name = name;
		this.description = description;
		this.birthDay = birthDay;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	

}
