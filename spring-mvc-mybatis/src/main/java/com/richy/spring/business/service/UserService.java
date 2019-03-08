package com.richy.spring.business.service;

import java.util.List;

import com.richy.spring.model.User;

public interface UserService {

	List<User> findAll();

	void addUser(User user);

	User getById(String userId);
}
