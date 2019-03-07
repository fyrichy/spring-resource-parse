package com.richy.spring.conditional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.richy.spring.config.ConditionConfig01;
import com.richy.spring.config.ConditionalConfig02;

public class ConditionalTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ConditionalConfig02.class);
		String[] beanNames = ac.getBeanDefinitionNames();
		System.out.println("-------------All Beans---------------");
		for(String beanName:beanNames) {
			if(!beanName.startsWith("org.springframework.context")) {
				System.out.println(beanName);
			}
		}
	}
}
