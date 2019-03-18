package com.richy.tx.xml.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.richy.tx.xml.model.User;
import com.richy.tx.xml.service.UserService;

public class UserMapperTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("tx1/TransactionProxyFactoryBean.xml");
		UserService userService = (UserService) context.getBean("userService");
		User user = userService.getById(5);
		System.out.println(user);
	}
}
