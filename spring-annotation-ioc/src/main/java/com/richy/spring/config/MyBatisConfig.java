package com.richy.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({PropertiesConfig.class})
public class MyBatisConfig {

	@Autowired
	PropertiesConfig propertiesConfig;
	
	public void printInfo() {
		System.out.println(propertiesConfig.getUrl());
	}
}
