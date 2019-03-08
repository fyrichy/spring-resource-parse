package com.richy.spring.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.richy.spring.business.service.UserService;
import com.richy.spring.mapper.UserMapper;
import com.richy.spring.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	public List<User> findAll() {
		return userMapper.findAll();
	}

	
	public void addUser(User user) {
		userMapper.addUser(user);
	}


	public User getById(String userId) {
		return userMapper.getById(userId);
	}

}
