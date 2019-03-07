package com.richy.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.richy.spring.config.DbConfig;
import com.richy.spring.config.DbProperties;

public class DbConfigTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(DbConfig.class);
		DbProperties db = (DbProperties) ac.getBean("dbDriver");
		System.out.println(db);
	}
}
