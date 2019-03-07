package com.richy.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

/**
 * @descrp：定义一个数据库连接驱动
 * @author：FyRichy
 * @time：2019年3月7日上午11:12:41
 */
public class DbProperties {

	@Value("${db.user}")
	private String user;
	
	@Value("${db.password}")
	private String password;
	
	@Value("${db.driverClass}")
	private String driverClass;

	@Override
	public String toString() {
		return "DbConfig [user=" + user + ", password=" + password + ", driverClass=" + driverClass + "]";
	}

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

	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	
	
	
}
