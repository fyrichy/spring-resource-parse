package com.richy.spring.config;



import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * @descrp：父容器，相当于以前的spring配置文件
 * 	父容器主要管理@Service,@Component,@Reposity等注解标注的类，
 * 而@Controller标注的类被web容器(子容器)管理
 * ，这里提醒分层的思想，所
 * @author：FyRichy
 * @time：2019年3月8日上午10:34:23
 */
@ComponentScan(basePackages= {"com.richy.spring.business"},
			   useDefaultFilters=true,
			   excludeFilters= {
					   @Filter(type=FilterType.ANNOTATION,classes= {Controller.class})
			   }
		)
@Configuration
@Import({MybatisConfig.class})
public class RootConfig{
	
}
