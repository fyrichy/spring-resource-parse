package com.richy.spring.autowire;

import org.springframework.stereotype.Service;

@Service
public class AutowireService {

	private MySqlDao mySqlDao;
	private OracleDao oracleDao;
	
	
	public MySqlDao getMySqlDao() {
		return mySqlDao;
	}
	public void setMySqlDao(MySqlDao mySqlDao) {
		this.mySqlDao = mySqlDao;
	}
	public OracleDao getOracleDao() {
		return oracleDao;
	}
	public void setOracleDao(OracleDao oracleDao) {
		this.oracleDao = oracleDao;
	}
	
	
}
