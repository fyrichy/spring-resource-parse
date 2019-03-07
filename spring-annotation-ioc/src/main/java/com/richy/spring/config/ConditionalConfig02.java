package com.richy.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.richy.spring.conditional.MyConditional;
import com.richy.spring.model.User;

/**
 * @descrp：将@Conditional注解作用在类上
 * @author：FyRichy
 * @time：2019年3月7日上午10:58:57
 */
@Configuration("conditionalConfig02")
@Conditional({MyConditional.class})
public class ConditionalConfig02 {

	@Bean(value="user02")
	public User user02() {
		System.out.println("开始创建user02");
		return new User("@Conditional作用在类上02", 2);
	}
	
	@Bean(value="user03")
	public User user03() {
		System.out.println("开始创建user03");
		return new User("@Conditional作用在类上03", 2);
	}
	
}
