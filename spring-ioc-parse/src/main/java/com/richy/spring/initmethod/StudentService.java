package com.richy.spring.initmethod;

public class StudentService {

	public StudentService() {
		System.out.println("构造器");
	}
	
	public void init() {
		System.out.println("对象实例化完成，进行初始化........");
	}
}
