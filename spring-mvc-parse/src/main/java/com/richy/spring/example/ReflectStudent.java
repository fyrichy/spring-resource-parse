package com.richy.spring.example;

import java.lang.reflect.Method;

public class ReflectStudent {

	public static void main(String[] args) {
		Class<Student> clazz = Student.class;
		Method[] methods = clazz.getDeclaredMethods();
		for(Method method:methods) {
			System.out.println(method.getName());
		}
	}
}
