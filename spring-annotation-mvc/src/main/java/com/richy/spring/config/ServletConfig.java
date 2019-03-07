package com.richy.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @descrp：web容器，只扫描@Controller标注的类
 * @author：FyRichy
 * @time：2019年3月7日下午3:05:42
 */
@ComponentScan( basePackages= {"com.richy.spring.business"},
				useDefaultFilters=false,
				includeFilters= {
					@Filter(type=FilterType.ANNOTATION,classes= {Controller.class})
			})
@EnableWebMvc
public class ServletConfig  extends WebMvcConfigurerAdapter{

	/**
	 * @descrp：定制视图解析器
	 * @author：FyRichy
	 * @time：2019年3月7日下午3:12:14
	 * @param registry
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	/**
	 * @descrp：静态资源访问
	 * @author：FyRichy
	 * @time：2019年3月7日下午3:12:44
	 * @param configurer
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		configurer.enable();
	}
}
