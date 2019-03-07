package com.richy.spring.componentscan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @descrp：父容器的配置文件，扫描除了@Controller以外的类
 * @author：FyRichy
 * @time：2019年3月7日上午11:47:48
 */
/*@Configuration
@ComponentScan(basePackages= {"com.richy.spring.componentscan"},useDefaultFilters=true,
			excludeFilters= {
				@Filter(type=FilterType.ANNOTATION,value= {Controller.class})
			})*/
public class ApplicationContextXml {

}
