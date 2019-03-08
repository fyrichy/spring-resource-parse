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

	@Value("${spring.datasource.user}")
	private String user;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${spring.datasource.dirver}")
	private String dirverClass;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.web.view.prefix}")
	private String viewPrefix;
	@Value("${spring.web.view.suffix}")
	private String viewSuffix;
	@Value("${spring.web.static.handler}")
	private String staticHandler;
	@Value("${spring.web.static.locations}")
	private String staticLocations;
	@Value("${mybatis.type.alias.package}")
	private String typeAliasPackage;
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
