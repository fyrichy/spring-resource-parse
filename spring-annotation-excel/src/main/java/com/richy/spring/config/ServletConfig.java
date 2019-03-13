package com.richy.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

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
public class ServletConfig implements WebMvcConfigurer{

	/**
	 * @descrp：定制视图解析器
	 * @author：FyRichy
	 * @time：2019年3月7日下午5:05:28
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver resourceViewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/views/",".jsp");
	}
	
	
	/**
	 * @descrp：视图配置
	 * @author：FyRichy
	 * @time：2019年3月7日下午5:06:54
	 * @param registry
	 */
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.viewResolver(resourceViewResolver());
	}
	
	/**
	 * @descrp：静态资源配置
	 * 		表示如果要访问/WEB-INF/static/下的资源：
	 * 		/WEB-INF/static/images/----/resources/images/
	 *        .....
	 * @author：FyRichy
	 * @time：2019年3月7日下午5:08:44
	 * @param registry
	 */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	System.out.println("静态资源配置调用....");
        registry.addResourceHandler("/resources/**")
        	.addResourceLocations("/WEB-INF/static/");
    }
}
