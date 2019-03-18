package com.richy.tx.xml.service.impl;

import com.richy.tx.xml.mapper.UserMapper;
import com.richy.tx.xml.model.User;
import com.richy.tx.xml.service.UserService;

public class UserServiceImpl implements UserService{

	private UserMapper userMapper;
	
	
	/**
	 * @descrp：根据id查询
	 * @author：FyRichy
	 * @time：2019年3月18日下午1:53:38
	 * @param id
	 * @return
	 */
	public User getById(Integer id) {
		return userMapper.getById(id);
	}
	
	

	
	
	
	
	
	
	
	
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	
}
