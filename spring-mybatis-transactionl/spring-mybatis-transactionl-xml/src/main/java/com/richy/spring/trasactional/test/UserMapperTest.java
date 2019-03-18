package com.richy.spring.trasactional.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.richy.spring.trasactional.model.User;
import com.richy.spring.trasactional.service.UserService;


public class UserMapperTest {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("tx1/TransactionProxyFactoryBean.xml");
		UserService userService = context.getBean("userServiceTransactionProxy",UserService.class);
		User user = new User(15, "mybatis事务15", 15, "女");
		userService.saveUser(user);
	}
}
