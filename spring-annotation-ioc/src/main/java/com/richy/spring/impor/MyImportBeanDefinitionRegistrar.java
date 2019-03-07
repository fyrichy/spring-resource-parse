package com.richy.spring.impor;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @descrp：自定义ImportBeanDefinitionRegistrar然后通过 @Import导入到spring容器中
 * @author：FyRichy
 * @time：2019年3月7日上午10:11:58
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar{

	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		//创建一个RootBeanDefinition,注册一个长方形
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Rectangle.class);
		//进行注册
		registry.registerBeanDefinition("rectangle", rootBeanDefinition);
	}

}
