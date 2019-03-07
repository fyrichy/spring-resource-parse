package com.richy.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.richy.spring.conditional.MyConditional;
import com.richy.spring.model.User;

/**
 * @descrp：将@Conditional注解作用在方法上
 * 	也就是会根据环境来判断，如果为windows操作系统就会创建实例成功
 * @author：FyRichy
 * @time：2019年3月7日上午10:49:24
 */
@Configuration("conditionConfig01")
public class ConditionConfig01 {

	@Conditional({MyConditional.class})
	@Bean(value="user01")
	public User user() {
		System.out.println("开始创建user01");
		return new User("@Conditional作用在方法上", 2);
	}
}
