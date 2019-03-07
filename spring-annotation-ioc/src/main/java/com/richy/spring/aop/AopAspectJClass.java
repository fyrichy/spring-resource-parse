package com.richy.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @descrp：定义一个切面类
 * @author：FyRichy
 * @time：2019年3月7日下午2:18:58
 */
@Aspect
public class AopAspectJClass {

	/**
	 * @descrp：针对Student的say方法做增强
	 * @author：FyRichy
	 * @time：2019年3月7日下午2:20:51
	 */
	@Pointcut("execution(* com.richy.spring.aop.StudentService.*(..))")
	public void pointcut() {}
	
	
	/**
	 * @descrp：环绕增强
	 * @author：FyRichy
	 * @time：2019年3月7日下午2:21:58
	 * @param p
	 * @return
	 */
	@Around("pointcut()")
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
