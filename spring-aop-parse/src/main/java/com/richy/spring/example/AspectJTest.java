package com.richy.spring.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectJTest {

	@Pointcut("execution(* *.test(..))")
	private void test() {}
	
	
	/**
	 * @descrp：定义一个环绕增强
	 * @author：FyRichy
	 * @time：2019年2月21日下午4:27:49
	 * @param p
	 * @return
	 */
	@Around("test()")
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
