package com.richy.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.richy.spring.config.ApplicationContextConfig;
import com.richy.spring.model.User;

/**
 * descrp：
 * @author：FyRichy
 * @time：2019年3月7日上午10:27:55
 */
public class MainTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
		//获取容器中所有注册的bean
		String[] beanNames = ac.getBeanDefinitionNames();
		System.out.println("-------------All Beans---------------");
		for(String beanName:beanNames) {
			if(!beanName.startsWith("org.springframework.context")) {
				System.out.println(beanName);
			}
		}
		User user = (User)ac.getBean("user");
		System.out.println(user);
	}
}
