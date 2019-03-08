package com.richy.spring.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @descrp：web容器，相当于springmvc-servlet.xml
 * @author：FyRichy
 * @time：2019年3月8日上午10:45:59
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.richy.spring.business"},
			   useDefaultFilters=false,
			   includeFilters= {
					@Filter(type=FilterType.ANNOTATION,classes= {Controller.class})
			   }
		)
@PropertySource("classpath:web.properties")
public class ServletConfig implements WebMvcConfigurer{


	/**
	 * @descrp：定制视图解析器
	 * @author：FyRichy
	 * @time：2019年3月8日上午10:50:51
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver resourceViewResolver() {
		return new InternalResourceViewResolver(getViewPrefix(),getViewSuffix());
	}
	
	/**
	 * @descrp：视图配置
	 * @author：FyRichy
	 * @time：2019年3月8日上午10:51:30
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
	 * @time：2019年3月8日上午10:51:30
	 * @param registry
	 */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	System.out.println("静态资源配置调用....");
        registry.addResourceHandler(getStaticHandler())
        	.addResourceLocations(getStaticLocations());
    }
    
    /**
     * @descrp：@ResponseBody对于对象装换成json配置
     * 类似如下：
     * 	 <bean id="mappingJackson2HttpMessageConverter" class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
                <property name="supportedMediaTypes">
                    <list>
                        <value>text/html;charset=UTF-8</value>
                        <value>application/json;charset=UTF-8</value>
                    </list>
                </property>
            </bean>
     * @author：FyRichy
     * @time：2019年3月8日下午1:51:15
     * @param converters
     */
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    	MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    	List<MediaType> jsonMediaTypes = new ArrayList<MediaType>(3);
    	jsonMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        jsonMediaTypes.add(MediaType.TEXT_HTML);
    	converter.setSupportedMediaTypes(jsonMediaTypes);
    	converters.add(converter);
    }
    
    
    
    
    
    @Value("${spring.web.view.prefix}")
	private String viewPrefix;
	@Value("${spring.web.view.suffix}")
	private String viewSuffix;
	@Value("${spring.web.static.handler}")
	private String staticHandler;
	@Value("${spring.web.static.locations}")
	private String staticLocations;
	
	
	
	public String getViewPrefix() {
		return viewPrefix;
	}

	public void setViewPrefix(String viewPrefix) {
		this.viewPrefix = viewPrefix;
	}

	public String getViewSuffix() {
		return viewSuffix;
	}

	public void setViewSuffix(String viewSuffix) {
		this.viewSuffix = viewSuffix;
	}

	public String getStaticHandler() {
		return staticHandler;
	}

	public void setStaticHandler(String staticHandler) {
		this.staticHandler = staticHandler;
	}

	public String getStaticLocations() {
		return staticLocations;
	}

	public void setStaticLocations(String staticLocations) {
		this.staticLocations = staticLocations;
	}
}
