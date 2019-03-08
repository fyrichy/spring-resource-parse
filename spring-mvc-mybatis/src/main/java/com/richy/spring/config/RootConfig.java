package com.richy.spring.config;



import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
/**
 * @descrp：父容器，相当于以前的spring配置文件
 * @author：FyRichy
 * @time：2019年3月8日上午10:34:23
 */
@ComponentScan(basePackages= {"com.richy.spring.business"},
			   useDefaultFilters=true,
			   excludeFilters= {
					   @Filter(type=FilterType.ANNOTATION,classes= {Controller.class})
			   }
		)
@Configuration
@Import({MybatisConfig.class})
public class RootConfig {
	
}
