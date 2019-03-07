package com.richy.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.richy.spring.impor.Circular;
import com.richy.spring.impor.MyImportBeanDefinitionRegistrar;
import com.richy.spring.impor.MyImportSelector;
import com.richy.spring.impor.Square;

/**
 * @descrp：多边形配置类
 *  @Import导入实例到Spring容器中有三种方式：
 *  1、基于@Configuration，然后直接在@Import后面填写class数组，
 *  2、基于自定义的ImportSelector的使用
 *  3、基于ImportBeanDefinitionRegistar的使用
 * 
 * @author：FyRichy
 * @time：2019年3月7日上午9:37:52
 */
@Configuration("polygonApplication")
@Import({Circular.class,Square.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class PolygonConfig {

}
