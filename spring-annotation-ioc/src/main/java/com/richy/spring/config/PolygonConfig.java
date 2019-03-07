package com.richy.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.richy.spring.model.Circular;
import com.richy.spring.model.Square;

/**
 * @descrp：多边形配置类
 * @author：FyRichy
 * @time：2019年3月7日上午9:37:52
 */
@Configuration("polygonApplication")
@Import({Circular.class,Square.class})
public class PolygonConfig {

}
