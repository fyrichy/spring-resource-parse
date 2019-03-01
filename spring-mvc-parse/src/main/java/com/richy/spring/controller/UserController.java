package com.richy.spring.controller;

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
	 * @descrp：
	 * 	@RequestBody注解可以将接收的JSON格式数据转换成为JAVA对象
	 *  @ResponseBody注解可以将java对象转换成JSON格式的数据响应给客户端
	 *  
	 *   如果客户端通过表单的形式发送数据，只要字段对应的上，属性能接受的到
	 * @author：FyRichy
	 * @time：2019年2月28日上午9:13:15
	 * @param user
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
	 * descrp：组合参数，包含Teacher和User的实例对象
	 * @author：FyRichy
	 * @time：2019年2月28日下午1:59:12
	 * @param compose
	 * @return
	 */
	@RequestMapping("/compose")
	@ResponseBody
	public String compose(@RequestBody Compose compose) {
		return compose.toString();
	}
	
	
	/**
	 * @descrp：自定义参数解析器实现
	 * @author：FyRichy
	 * @time：2019年2月28日下午2:11:41
	 * @param compose
	 * @return
	 */
	@RequestMapping("/customize")
	@ResponseBody
	public String customize(@com.richy.spring.annotation.Compose Compose compose) {
		return compose.toString();
	}
	
}
