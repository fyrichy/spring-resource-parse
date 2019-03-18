package com.richy.spring.trasactional.service;

import com.richy.spring.trasactional.model.User;

public interface UserService {

	public User getById(Integer id);
	
	public void saveUser(User user)throws Exception;
}
