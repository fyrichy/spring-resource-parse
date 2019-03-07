package com.richy.spring.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @descrp：自定义一个condition，根据当前的操作系统匹配
 * @author：FyRichy
 * @time：2019年3月7日上午10:44:24
 */
public class MyConditional implements Condition{

	/**
	 * @descrp：当前操作系统为Windows 7，在使用@Conditional({MyConditional.class})如果匹配不到，这不会创建实例，
	 * @author：FyRichy
	 * @time：2019年3月7日上午10:57:00
	 * @param context
	 * @param metadata
	 * @return
	 */
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		//获取当前的系统环境
		Environment env = context.getEnvironment();
		String system = env.getProperty("os.name");
		System.out.println("当前的系统环境为:"+system);
		if("Windows 72".equals(system)) {
			return true;
		}
		return false;
	}

}
