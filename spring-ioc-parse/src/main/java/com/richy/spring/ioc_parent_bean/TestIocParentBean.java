package com.richy.spring.ioc_parent_bean;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;


public class TestIocParentBean {

	public static void main(String[] args) {
		//创建一个IOC配置文件的抽象资源
		ClassPathResource resource = new ClassPathResource("ioc-parent-bean/ioc-parent-bean.xml");
		//创建一个BeanFactory的实现类
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		//创建一个载入xml文件形式的BeanDefinition读取器，并将BeanFactory通过构造参数传递进去
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		//读取资源配置信息，并在XmlBeanDefinitionReader中解析，将解析完的BeanDefinition注册到BeanFactory中
		reader.loadBeanDefinitions(resource);
		//进行测试
		BaoMa baoMa = (BaoMa)factory.getBean("baoMa");
		System.out.println(baoMa);
	}
}
