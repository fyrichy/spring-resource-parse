package com.richy.spring.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.richy.spring.business.service.UserService;
import com.richy.spring.model.User;

/**
 * @descrp：用户controller
 * @author：FyRichy
 * @time：2019年3月8日上午10:57:47
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * @descrp：查询所有
	 * @author：FyRichy
	 * @time：2019年3月8日上午11:06:46
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public List<User> findAll(){
		List<User> users = userService.findAll();
		return users;
	}
	
	
	/**
	 * @descrp：添加用户
	 * @author：FyRichy
	 * @time：2019年3月8日下午2:44:27
	 * @param user
	 * @return
	 */
	@RequestMapping("/addUser")
	@ResponseBody
	public User addUser(@RequestBody User user){
		userService.addUser(user);
		return user;
	}
	
	/**
	 * @descrp：根据id查询
	 * @author：FyRichy
	 * @time：2019年3月8日下午2:52:28
	 * @param userId
	 * @return
	 */
	@RequestMapping("/getById")
	@ResponseBody
	public User getById(String userId) {
		return userService.getById(userId);
	}
	
	
}
