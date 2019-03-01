package com.richy.spring.ioc01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/ioc.xml");
		Dao dao = (Dao)ac.getBean("daoImpl");
		dao.select();
	}
}
