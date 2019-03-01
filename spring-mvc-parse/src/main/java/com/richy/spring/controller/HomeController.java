package com.richy.spring.controller;


import com.richy.spring.exception.ArgumentErrorException;


public class HomeController {

	
	public String index(){
		int b = 1;
		if(1==b) {
			throw new ArgumentErrorException("The Arguments Error Exception ,Plaese Try Agin...");
		}
		return "Welcome To SpringMVC Resources Parse......";
	}
}
