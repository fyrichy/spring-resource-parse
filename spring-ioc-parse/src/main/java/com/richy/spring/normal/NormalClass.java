package com.richy.spring.normal;

/**
 * @descrp：这里表示一个普通的javaBean
 * @author：FyRichy
 * @time：2019年2月19日上午9:47:37
 */
public class NormalClass {

	private String name;
	private String className;
	private String description;
	
	//无参构造器
	public NormalClass() {
		super();
	}
	
	//有参构造器
	public NormalClass(String name, String className, String description) {
		super();
		this.name = name;
		this.className = className;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "NormalClass [name=" + name + ", className=" + className + ", description=" + description + "]";
	}
	
	
}
