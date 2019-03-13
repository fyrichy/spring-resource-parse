package com.richy.spring.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @descrp：自定义的BeanFactoryPostProcessor
 * @author：FyRichy
 * @time：2019年3月13日下午2:26:47
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("自定义的BeanFactoryPostProcessor");
	}

}
