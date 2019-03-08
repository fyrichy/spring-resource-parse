package com.richy.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.richy.spring.config.MybatisConfig;
import com.richy.spring.config.PropertiesConfig;

public class GennericTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(MybatisConfig.class);
		 String[] definitionNames = ac.getBeanDefinitionNames();
	        for (String name : definitionNames) {
	        	if(!name.startsWith("org.springframework.context")) {
	        		System.out.println(name);
	        	}
	        }
	}
}
