package com.richy.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AopTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AopConfig.class);
		StudentService studentService = (StudentService)ac.getBean("studentService");
		studentService.say();
	}
}
