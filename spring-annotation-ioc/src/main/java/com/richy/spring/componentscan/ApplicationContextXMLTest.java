package com.richy.spring.componentscan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @descrp：模拟applicationContext.xml配置，只扫描@Service,@Reposity,@Component标注的类
 * @author：FyRichy
 * @time：2019年3月7日上午11:51:10
 */
public class ApplicationContextXMLTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(ApplicationContextXml.class);
        String[] definitionNames = applicationContext2.getBeanDefinitionNames();
        for (String name : definitionNames) {
        	if(!name.startsWith("org.springframework.context")) {
        		System.out.println(name);
        	}
        }
	}
}
