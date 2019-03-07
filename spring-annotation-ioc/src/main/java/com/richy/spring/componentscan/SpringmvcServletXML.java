package com.richy.spring.componentscan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @descrp：定义Bao扫描配置类,只扫描controller
 * 	<context:component-scan package="com.richy.spring.componentscan" use-default-filters="false">
 * 		<context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
 *  </context:component-scan/>
 * @author：FyRichy
 * @time：2019年3月7日上午11:29:21
 */
@ComponentScan(basePackages= {"com.richy.spring.componentscan"},useDefaultFilters=false,
			includeFilters= {
				@Filter(type=FilterType.ANNOTATION,value= {Controller.class}),
				@Filter(type=FilterType.CUSTOM,value= {ServiceFilter.class})
			})
@Configuration
public class SpringmvcServletXML {

}
