package com.richy.tx.xml.service;

import com.richy.tx.xml.model.User;

public interface UserService {

	public User getById(Integer id);
	
	public void saveUser(User user)throws Exception;
}
