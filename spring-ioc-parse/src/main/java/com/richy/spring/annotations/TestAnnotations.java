package com.richy.spring.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotations {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("annotations/annotations.xml");
		System.out.println(ac.getBean("student"));
	}
}
