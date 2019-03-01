package com.richy.spring.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestPersonService {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("service/service.xml");
		PersonService personService = (PersonService)ac.getBean("personService");
		personService.printInfo();
	}
}
