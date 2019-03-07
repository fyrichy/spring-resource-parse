package com.richy.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @descrp：相当于Spring的总配置文件(applicationContext.xml)
 * @author：FyRichy
 * @time：2019年3月7日上午10:26:09
 */
@Configuration("applicationContextConfig")
@Import({BeanConfig.class,PolygonConfig.class})
public class ApplicationContextConfig {

}
