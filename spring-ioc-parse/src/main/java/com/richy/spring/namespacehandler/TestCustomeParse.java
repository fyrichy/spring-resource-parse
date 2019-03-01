package com.richy.spring.namespacehandler;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.richy.spring.namespacehandler.pojo.User;


public class TestCustomeParse {

	public static void main(String[] args) {
		//1、创建一个ioc配置文件的抽象资源
		ClassPathResource resource = new ClassPathResource("namespacehandler/namespacehandler.xml");
		
		//2、创建一个BeanFactory的实现
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		
		//3、创建一个载入xml文件形式的beanDefinition读取器，将banFactory通过构造函数传递进去
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		
		//4、读取配置文件信息，并在XmlBeanDefinition中解析，将解析完的BeanDefinition注册到beanFactory中
		reader.loadBeanDefinitions(resource);
		
		//5、根据名称获取bean---getBean(String beanName)
		User user = (User)beanFactory.getBean("userId");
		System.out.println(user);
	}
}
