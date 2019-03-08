package com.richy.spring.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @descrp：mybatis相关配置
 * @author：FyRichy
 * @time：2019年3月8日下午12:42:58
 */
@Configuration
@MapperScan(basePackages= {"com.richy.spring.mapper"})
@Import({PropertiesConfig.class})
public class MybatisConfig {
	
	@Autowired
	PropertiesConfig propertiesConfig;
	
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
		dataSource.setUsername(propertiesConfig.getUser());
		dataSource.setPassword(propertiesConfig.getPassword());
		dataSource.setUrl(propertiesConfig.getUrl());
		dataSource.setDriverClassName(propertiesConfig.getDirverClass());
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
		sqlSessionFactoryBean.setTypeAliasesPackage(propertiesConfig.getTypeAliasPackage());
		//支持xml方式的动态sql
		PathMatchingResourcePatternResolver classPathResource = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(classPathResource.getResources(propertiesConfig.getMapperLocations()));
		return sqlSessionFactoryBean;
	}
}
