package com.richy.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.richy.spring.model.User;

public interface UserMapper {

	List<User> findAll();

	void addUser(User user);

	/**
	 * @descrp：根据主键查询，使用注解方式
	 * @author：FyRichy
	 * @time：2019年3月8日下午2:53:17
	 * @param userId
	 * @return
	 */
	@Select("SELECT ID,NAME,AGE,SEX FROM t_user WHERE ID = #{userId}")
	User getById(@Param("userId")String userId);
}
