package com.richy.spring.trasactional.mapper;

import org.apache.ibatis.annotations.Param;

import com.richy.spring.trasactional.model.User;


public interface UserMapper {

	User getById(@Param("id")Integer id);
	
	void saveUser(User user);
}
