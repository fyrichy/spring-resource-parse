package com.richy.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;

/**
 * @descrp：父容器，扫描除了@Controller标注的其他注解标注的类@Service,@Reposity,@Component
 *  
 * @author：FyRichy
 * @time：2019年3月7日下午3:09:12
 */
@ComponentScan( basePackages= {"com.richy.spring.business"},
				useDefaultFilters=true,
				excludeFilters= {
					@Filter(type=FilterType.ANNOTATION,classes= {Controller.class})
				})
public class RootConfig {

}
