package com.richy.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value= {"classpath:db.properties"})
@Configuration("dbConfig")
public class DbConfig {
	
	@Bean
	public DbProperties dbDriver() {
		return new DbProperties();
	}

}
