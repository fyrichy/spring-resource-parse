package com.richy.spring.createbean;

/**
 * @descr：创建User的工厂
 * @author： Richy
 * @time：下午9:22:29
 */
public class UserFactory {

	//实例方法创建对象
	public User getInstance() {
		System.out.println("实例方法创建对象");
		return new User("002", "user-by-factory");
	}
	
	//静态方法创建User
	public static User getStaticInstance() {
		System.out.println("静态方法创建User");
		return new User("003","user-by-staticFactory");
	}
}
