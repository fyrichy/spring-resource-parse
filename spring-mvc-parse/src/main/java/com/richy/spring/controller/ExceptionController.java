package com.richy.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.richy.spring.exception.ArgumentErrorException;
import com.richy.spring.model.Person;

/**
 * @descrp：异常Controller
 * @author：FyRichy
 * @time：2019年3月1日下午2:25:42
 */
@Controller
@RequestMapping("/exception")
public class ExceptionController {

	/**
	 * @descrp：用于拦截RuntimeException，拦截到了跳转到异常页面
	 * @author：FyRichy
	 * @time：2019年3月1日下午2:30:23
	 * @return
	 */
	@RequestMapping("/toExceptionPage")
	public String toExceptionPage() {
		int a = 0;
		if(0==a) {
			throw new RuntimeException("出异常了，跳转到异常页面....");
		}
		return "";
	}
	
	
	/**
	 * @descrp：用于拦截ArgumentErrorException，返回错误信息
	 * @author：FyRichy
	 * @time：2019年3月1日下午2:30:48
	 * @return
	 */
	@RequestMapping("/returnExceptionMessage")
	@ResponseBody
	public String returnExceptionMessage() {
		int a = 0;
		if(0==a) {
			throw new ArgumentErrorException("ArgumentErrorException Return The Exception Message...");
		}
		return "";
	}
	
	/**
	 * @descrp：正常请求
	 * @author：FyRichy
	 * @time：2019年3月4日上午11:16:18
	 * @return
	 */
	@RequestMapping("/normalRequest")
	public String normalRequest(String username,String password,Model model) {
		Person person = new Person(username, password);
		model.addAttribute("person", person);
		return "/normal/page";
	}
	
	
	/**
	 * @descrp：进行重定向
	 * @author：FyRichy
	 * @time：2019年3月4日下午3:01:34
	 * @param username
	 * @param password
	 * @param model
	 * @return
	 */
	@RequestMapping("/redirect")
	public String redirect(String username,String password) {
		return "redirect:/exception/normalRequest.html?username="+username+"&password="+password;
	}
}
