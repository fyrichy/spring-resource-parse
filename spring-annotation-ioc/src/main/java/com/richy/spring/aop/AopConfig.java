package com.richy.spring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.richy.spring.postprocessor.MyBeanFactoryPostProcessor;

/**
 * @descrp：aop配置类
 * @author：FyRichy
 * @time：2019年3月7日下午2:22:20
 */
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

	@Bean
	public AopAspectJClass aopAspectJClass() {
		return new AopAspectJClass();
	}
	
	@Bean
	public StudentService studentService() {
		return new StudentService();
	}
}
