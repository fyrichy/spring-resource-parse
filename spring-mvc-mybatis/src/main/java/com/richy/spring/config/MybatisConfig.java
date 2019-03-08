package com.richy.spring.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @descrp：mybatis相关配置
 * @author：FyRichy
 * @time：2019年3月8日下午12:42:58
 */
@Configuration
@MapperScan(basePackages= {"com.richy.spring.mapper"})
@PropertySource("classpath:db.properties")
public class MybatisConfig {
	
	/**
	 * @descrp：配置数据源
	 * @author：FyRichy
	 * @time：2019年3月8日上午10:38:33
	 * @param propertiesConfig				
	 * @return
	 */
	@Bean
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUsername(getUser());
		dataSource.setPassword(getPassword());
		dataSource.setUrl(getUrl());
		dataSource.setDriverClassName(getDirverClass());
		return dataSource;
	}
	
	
	
	/**
	 * @descrp：配置mybatis的sqlSessionFactoryBean	
	 * @author：FyRichy
	 * @time：2019年3月8日上午10:42:19
	 * @param dataSource
	 * @return
	 * @throws IOException 
	 */
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		//设置数据源
		sqlSessionFactoryBean.setDataSource(dataSource);
		//设置实体类别名
		sqlSessionFactoryBean.setTypeAliasesPackage(getTypeAliasPackage());
		//支持xml方式的动态sql
		PathMatchingResourcePatternResolver classPathResource = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(classPathResource.getResources(getMapperLocations()));
		return sqlSessionFactoryBean;
	}
	
	
	@Value("${spring.datasource.user}")
	private String user;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${spring.datasource.dirver}")
	private String dirverClass;
	@Value("${spring.datasource.url}")
	private String url;
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
