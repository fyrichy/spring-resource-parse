package com.richy.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @descrp：配置文件配置类
 * @author：FyRichy
 * @time：2019年3月8日上午10:29:19
 */
@Configuration("propertiesConfig")
@PropertySource("classpath:application.properties")
public class PropertiesConfig {
	//数据库用户名
	@Value("${spring.datasource.user}")
	private String user;
	
	//数据库密码
	@Value("${spring.datasource.password}")
	private String password;
	
	//数据库连接驱动
	@Value("${spring.datasource.dirver}")
	private String dirverClass;
	
	//数据库url
	@Value("${spring.datasource.url}")
	private String url;
	
	//视图文件前缀
	@Value("${spring.web.view.prefix}")
	private String viewPrefix;
	
	//视图文件后缀
	@Value("${spring.web.view.suffix}")
	private String viewSuffix;
	
	//静态文件的访问路径
	@Value("${spring.web.static.handler}")
	private String staticHandler;
	
	//静态文件的本地映射路径
	@Value("${spring.web.static.locations}")
	private String staticLocations;
	
	//mybati实体类的包路径，用作别名
	@Value("${mybatis.type.alias.package}")
	private String typeAliasPackage;
	
	//mapping文件的包路径
	@Value("${mybatis.mapper.locations}")
	private String mapperLocations;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDirverClass() {
		return dirverClass;
	}

	public void setDirverClass(String dirverClass) {
		this.dirverClass = dirverClass;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

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

	public String getTypeAliasPackage() {
		return typeAliasPackage;
	}

	public void setTypeAliasPackage(String typeAliasPackage) {
		this.typeAliasPackage = typeAliasPackage;
	}

	public String getMapperLocations() {
		return mapperLocations;
	}

	public void setMapperLocations(String mapperLocations) {
		this.mapperLocations = mapperLocations;
	}
}
