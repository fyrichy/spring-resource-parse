package com.richy.tx.xml.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.richy.tx.xml.model.User;
import com.richy.tx.xml.service.UserService;

public class UserMapperTest {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("tx1/TransactionProxyFactoryBean.xml");
		UserService userService = context.getBean("userServiceTransactionProxy",UserService.class);
		User user = new User(14, "mybatis事务14", 14, "女");
		userService.saveUser(user);
	}
}
