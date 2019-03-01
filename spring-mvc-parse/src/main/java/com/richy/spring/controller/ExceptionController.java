package com.richy.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.richy.spring.exception.ArgumentErrorException;

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
}
