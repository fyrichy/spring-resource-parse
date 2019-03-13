package com.richy.spring.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @descrp：标注在需要导出的字段上
 * @author：FyRichy
 * @time：2019年3月12日下午3:28:45
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelField {

	//标题，也就是导出的excel的标题
	String title() default "";
	
	//排序，标题排序
	int sort() default 0;
}
