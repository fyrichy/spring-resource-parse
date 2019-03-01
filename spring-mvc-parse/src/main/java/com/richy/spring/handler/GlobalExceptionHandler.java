package com.richy.spring.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.richy.spring.exception.ArgumentErrorException;

/**
 * @descrp：全局异常处理器
 * @author：FyRichy
 * @time：2019年2月25日下午3:39:20
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	
	/**
	 * @descrp：RuntimeException处理方式，
	 * @author：FyRichy
	 * @time：2019年2月25日下午3:39:38
	 * @param e
	 * @return
	 */
	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException(RuntimeException e) {
		return "/exception/runtimeexception";
	}
	
	
	/**
	 * @descrp：ArgumentErrorException处理方式
	 * @author：FyRichy
	 * @time：2019年2月25日下午3:39:52
	 * @param e
	 * @return
	 */
	@ExceptionHandler(ArgumentErrorException.class)
	@ResponseBody
	public String hadleArgumentErrorException(ArgumentErrorException e) {
		return e.getMessage();
	}
}
