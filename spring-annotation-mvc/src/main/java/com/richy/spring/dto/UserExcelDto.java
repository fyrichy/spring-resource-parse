package com.richy.spring.dto;

import java.io.Serializable;
import java.util.Date;

import com.richy.spring.annotation.ExcelField;

/**
 * @descrp：User类的excel导出对象
 * @author：FyRichy
 * @time：2019年3月12日下午3:38:26
 */
public class UserExcelDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ExcelField(title="用户年龄",sort=2)
	private String age;
	
	@ExcelField(title="用户姓名",sort=1)
	private String name;
	
	@ExcelField(title="用户描述",sort=4)
	private String description;
	
	@ExcelField(title="用户生日",sort=3)
	private Date birthDay;
	
	
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
