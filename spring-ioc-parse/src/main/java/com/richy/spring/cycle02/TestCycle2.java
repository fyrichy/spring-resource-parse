package com.richy.spring.cycle02;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;


public class TestCycle2 {

	public static void main(String[] args) {
		//创建一个IOC配置文件的抽象资源
		ClassPathResource resource = new ClassPathResource("cycle2/cycle2.xml");
		//创建一个BeanFactory的实现类
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		//创建一个载入xml文件形式的BeanDefinition读取器，并将BeanFactory通过构造参数传递进去
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		//读取资源配置信息，并在XmlBeanDefinitionReader中解析，将解析完的BeanDefinition注册到BeanFactory中
		reader.loadBeanDefinitions(resource);
		//进行测试
		Cycle2 cycle2 = (Cycle2)factory.getBean("cycle2");
		System.out.println(cycle2);
	}
}
