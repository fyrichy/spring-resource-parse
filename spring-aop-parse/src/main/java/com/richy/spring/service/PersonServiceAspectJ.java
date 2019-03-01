package com.richy.spring.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PersonServiceAspectJ {

	@Pointcut("execution(* com.richy.spring.service.PersonServiceImpl.*(..))")
	public void around() {}
	
	
	@Around("around()")
	public Object aroundAdvice(ProceedingJoinPoint p) {
		System.out.println("开始....");
		Object o = null;
		try {
			o = p.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("结束....");
		return o;
	}
}
