package com.richy.spring.impor;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @descrp：自定义ImportSelector，然后通过@Import导入到Spring容器中
 * @author：FyRichy
 * @time：2019年3月7日上午10:09:02
 */
public class MyImportSelector implements ImportSelector{

	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[] {"com.richy.spring.impor.Triangle"};
	}

}
