package com.richy.tx.xml.mapper;

import org.apache.ibatis.annotations.Param;

import com.richy.tx.xml.model.User;

public interface UserMapper {

	User getById(@Param("id")Integer id);
}
