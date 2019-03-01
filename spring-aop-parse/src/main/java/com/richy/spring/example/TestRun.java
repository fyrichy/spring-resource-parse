package com.richy.spring.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRun {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("example/example.xml");
		TestBean tb = (TestBean)ac.getBean("testBean");
		tb.test();
	}
}
