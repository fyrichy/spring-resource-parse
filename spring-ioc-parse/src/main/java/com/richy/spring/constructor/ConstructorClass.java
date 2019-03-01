package com.richy.spring.constructor;

/**
 * @descrp：测试通过构造函数实例化bean
 * @author：FyRichy
 * @time：2019年2月20日下午2:11:55
 */
public class ConstructorClass {

	private String name;
	private String description;
	private Animal animal;
	private Monkey monkey;
	
	/**
	 * 构造器的参数是父子关系
	 */
	public ConstructorClass(String name, String description,Animal animal) {
		super();
		this.name = name;
		this.description = description;
		this.animal = animal;
	}
	
	public ConstructorClass(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	
	public ConstructorClass() {
		super();
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
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public Monkey getMonkey() {
		return monkey;
	}
	public void setMonkey(Monkey monkey) {
		this.monkey = monkey;
	}
	@Override
	public String toString() {
		return "ConstructorClass [name=" + name + ", description=" + description + "]";
	}
	
	
}
