package com.richy.spring.componentscan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @descrp：测试注解@ComponentScan注解，只扫描@Controller标注的类
 * @author：FyRichy
 * @time：2019年3月7日上午11:30:54
 */
public class SpringmvcServletXMLTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(SpringmvcServletXML.class);
        String[] definitionNames = applicationContext2.getBeanDefinitionNames();
        for (String name : definitionNames) {
        	if(!name.startsWith("org.springframework.context")) {
        		System.out.println(name);
        	}
        }
	}
}
