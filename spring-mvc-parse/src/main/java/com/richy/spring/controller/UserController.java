package com.richy.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.richy.spring.model.Compose;
import com.richy.spring.model.User;

@Controller
@RequestMapping("/user")
public class UserController {

	
	/**
	 * @descrp：使用 @RequestBody接受json串数组
	 * @author：FyRichy
	 * @time：2019年3月5日上午9:13:43
	 * @param users
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public String findAll(@RequestBody List<User> users) {
		StringBuffer sb = new StringBuffer();
		if(null != users && users.size() > 0) {
			for(User user:users) {
				sb.append(user.toString()+"\n");
			}
		}
		return sb.toString();
	}
	
	@RequestMapping("/getById")
	public String getById(String userId) {
		
		return "/user/userInfo";
	}
	
	
	/**
	 * @descrp：使用@RequestBody解析组合参数json串
	 * @author：FyRichy
	 * @time：2019年3月5日上午9:13:16
	 * @param compose
	 * @return
	 */
	@RequestMapping("/compose")
	@ResponseBody
	public String compose(@RequestBody Compose compose) {
		return compose.toString();
	}
	
	
	/**
	 * @descrp：实现自定义的HandlerMethodArgumentResolver，解析组合参数
	 * @author：FyRichy
	 * @time：2019年3月5日上午9:12:49
	 * @param compose
	 * @return
	 */
	@RequestMapping("/customize")
	@ResponseBody
	public String customize(@com.richy.spring.annotation.Compose Compose compose) {
		return compose.toString();
	}
	
	/**
	 * @descrp：json串参数请求
	 * @author：FyRichy
	 * @time：2019年3月5日上午9:08:22
	 * @param jsonStr
	 * @return
	 */
	@RequestMapping("/normalArgs")
	@ResponseBody
	public String normalArgs(@RequestBody String jsonStr) {
		return jsonStr;
	}
	
	/**
	 * @descrp：@ResponseBody返回一个对象
	 * @author：FyRichy
	 * @time：2019年3月5日上午9:54:24
	 * @param userId
	 * @return
	 */
	@RequestMapping("/findById")
	@ResponseBody
	public User findById(String userId) {
		System.out.println("======"+userId+"======");
		User user = new User("user01",21, "This Is User01");
		return user;
	}
	
	
	/**
	 * @descrp：返回集合转换成json
	 * @author：FyRichy
	 * @time：2019年3月5日下午1:43:21
	 * @return
	 */
	@RequestMapping("/findList")
	@ResponseBody
	public List<User> findList() {
		List<User> users = new ArrayList<User>();
		for(int i=0;i<10;i++) {
			User user = new User("user"+i,21+i, "This Is User"+i);
			users.add(user);
		}
		return users;
	}
}
