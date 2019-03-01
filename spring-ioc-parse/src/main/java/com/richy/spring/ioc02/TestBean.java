package com.richy.spring.ioc02;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class TestBean {

	public static void main(String[] args) {
		//1、创建一个ioc配置文件的抽象资源
		ClassPathResource resource = new ClassPathResource("ioc02/ioc02.xml");
		
		//2、创建一个BeanFactory的实现
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		
		//3、创建一个载入xml文件形式的beanDefinition读取器，将banFactory通过构造函数传递进去
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		
		//4、读取配置文件信息，并在XmlBeanDefinition中解析，将解析完的BeanDefinition注册到beanFactory中
		reader.loadBeanDefinitions(resource);
		
		//5、根据名称获取bean---getBean(String beanName)
		Student student = (Student)beanFactory.getBean("student");
		System.out.println(student);
	}
}
