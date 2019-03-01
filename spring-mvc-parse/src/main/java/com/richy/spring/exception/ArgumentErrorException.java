package com.richy.spring.exception;

/**
 * @descrp：参数错误异常
 * @author：FyRichy
 * @time：2019年2月25日下午3:35:13
 */
public class ArgumentErrorException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public ArgumentErrorException() {
		
	}
	
	public ArgumentErrorException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
