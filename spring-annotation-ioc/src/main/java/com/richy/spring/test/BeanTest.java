package com.richy.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.richy.spring.config.BeanConfig;
import com.richy.spring.model.User;

public class BeanTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfig.class);
		User user = (User) ac.getBean("user");
		System.out.println(user);
	}
}
