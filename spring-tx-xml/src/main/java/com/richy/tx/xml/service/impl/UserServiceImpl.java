package com.richy.tx.xml.service.impl;

import com.richy.tx.xml.mapper.UserMapper;
import com.richy.tx.xml.model.User;
import com.richy.tx.xml.service.UserService;

public class UserServiceImpl implements UserService{

	private UserMapper userMapper;
	public UserMapper getUserMapper() {
		return userMapper;
	}
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
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

	/**
	 * @descrp：对此方法开启事务，如果抛出异常，会不会插入成功
	 * @author：FyRichy
	 * @time：2019年3月18日下午2:17:57
	 * @param user
	 */
	@Override
	public void saveUser(User user)throws Exception {
		userMapper.saveUser(user);
		//int a = 2/0;
	}
	
	
}
