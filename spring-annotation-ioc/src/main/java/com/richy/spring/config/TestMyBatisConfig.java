package com.richy.spring.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMyBatisConfig {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(MyBatisConfig.class);
		MyBatisConfig mc = (MyBatisConfig)ac.getBean(MyBatisConfig.class);
		mc.printInfo();
		String[] beanNames = ac.getBeanDefinitionNames();
		for(String beanName:beanNames) {
			System.out.println(beanName);
		}
	}
}
