package com.richy.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.richy.spring.model.User;

/**
 * @descrp：用于注册bean
 * @author：FyRichy
 * @time：2019年3月7日上午8:56:29
 */
@Configuration
public class BeanConfig {

	@Bean
	public User user() {
		return new User("spring注解驱动开发", 2);
	}
}
