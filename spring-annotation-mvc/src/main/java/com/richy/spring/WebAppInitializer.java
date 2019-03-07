package com.richy.spring;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.richy.spring.config.RootConfig;
import com.richy.spring.config.ServletConfig;

/**
 * @descrp：web容器启动的时候创建对象，调用方法来初始化容器
 * @author：FyRichy
 * @time：2019年3月7日下午3:01:26
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	/**
	 * @descrp：获取根容器的配置类，初始化父容器，以前的applicationContext.xml
	 * @author：FyRichy
	 * @time：2019年3月7日下午3:01:50
	 * @return
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {RootConfig.class};
	}

	/**
	 * @descrp：获取web容器配置类，初始化web容器(子容器),以前的springmvc-servlet.xml
	 * @author：FyRichy
	 * @time：2019年3月7日下午3:02:21
	 * @return
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {ServletConfig.class};
	}

	/**
	 * @descrp：获取DispatcherServlet的映射信息
	 * 	/：拦截所有请求（包括静态资源（xx.js,xx.png）），但是不包括*.jsp；
	 *  /*：拦截所有请求；连*.jsp页面都拦截；jsp页面是tomcat的jsp引擎解析的；
	 * @author：FyRichy
	 * @time：2019年3月7日下午3:03:11
	 * @return
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"*.html"};
	}

}
