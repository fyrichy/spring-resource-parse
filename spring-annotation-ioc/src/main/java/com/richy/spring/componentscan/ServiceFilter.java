package com.richy.spring.componentscan;

import java.io.IOException;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

/**
 * @descrp：自定义filter
 * @author：FyRichy
 * @time：2019年3月7日上午11:53:59 
 */
public class ServiceFilter implements TypeFilter{

	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		//获取注解元数据
		AnnotationMetadata annotationMedata = metadataReader.getAnnotationMetadata();
		if(annotationMedata.hasAnnotation("com.richy.spring.annotaion.FyRichy")) {
			return true;
		}
		return false;
	}

}
