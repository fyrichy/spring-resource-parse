package com.richy.spring.postprocessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestPostProcessor {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ProcessorConfig.class);
		String[] beanNames = ac.getBeanDefinitionNames();
		for(String beanName:beanNames) {
			System.out.println(beanName);
		}
	}
}
