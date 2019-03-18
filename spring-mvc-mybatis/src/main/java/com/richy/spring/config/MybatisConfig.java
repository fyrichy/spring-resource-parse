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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @descrp：mybatis相关配置
 * @author：FyRichy
 * @time：2019年3月8日下午12:42:58
 */
@Configuration
@MapperScan(basePackages= {"com.richy.spring.mapper"})
@Import({PropertiesConfig.class})
//使用事务驱动管理，就好比在xml配置中配置<tx:annotation-driven/>
@EnableTransactionManagement
public class MybatisConfig implements TransactionManagementConfigurer{
	
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
	
	
	/**
	 * @descrp：实现接口方法，注册注解事务，当@Transactional 使用的时候产生数据库事务 
	 * @author：FyRichy
	 * @time：2019年3月18日上午11:32:18
	 * @param dataSource
	 * @return
	 */
	@Override
	@Bean(name="annotationDrivenTransactionManager")
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}

}
