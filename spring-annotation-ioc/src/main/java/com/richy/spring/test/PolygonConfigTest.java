package com.richy.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.richy.spring.config.PolygonConfig;
import com.richy.spring.model.Circular;

public class PolygonConfigTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(PolygonConfig.class);
		//获取容器中所有注册的bean
		String[] beanNames = ac.getBeanDefinitionNames();
		for(String beanName:beanNames) {
			System.out.println(beanName);
		}
		Circular circular = (Circular) ac.getBean("com.richy.spring.model.Circular");
		circular.printInfo();
	}
}
