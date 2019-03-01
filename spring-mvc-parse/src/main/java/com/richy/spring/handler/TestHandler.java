package com.richy.spring.handler;

import java.io.BufferedInputStream;
import java.io.InputStream;

import org.springframework.asm.ClassReader;
import org.springframework.core.NestedIOException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.classreading.AnnotationMetadataReadingVisitor;
import org.springframework.stereotype.Component;

/**
 * @descrp：如下代碼可以掃描被Spring的@Component註解標註過的註解的類
 * @author：FyRichy
 * @time：2019年3月1日下午4:55:00
 */
public class TestHandler {

	 public static void main(String[] args) throws Exception {
		 
		 String packageSearchPath = "classpath*:com/richy/spring/handler/**/*.class";  
		 PathMatchingResourcePatternResolver  pathResolver = new PathMatchingResourcePatternResolver();  
		 Resource[] rr = pathResolver.getResources(packageSearchPath);  
		 for(Resource r:rr){  
			 AnnotationMetadataReadingVisitor visitor = new AnnotationMetadataReadingVisitor(Thread.currentThread().getContextClassLoader());  
             InputStream is = new BufferedInputStream(r.getInputStream());  
             ClassReader classReader;  
             try {  
             	//创建ASM的ClassReader  
                 classReader = new ClassReader(is);  
             }catch (IllegalArgumentException ex) {  
                 throw new NestedIOException("ASM ClassReader failed to parse class file - " +  
                         "probably due to a new Java class file version that isn't supported yet: " + r, ex);  
             }  
             finally {  
                 is.close();  
             }  
             //调用reader的接受方法，这个方法实际就是解析class字节码的实现，这里使用了Visitor模式  
             classReader.accept(visitor, ClassReader.SKIP_DEBUG);  
             for(String annotationType:visitor.getAnnotationTypes()){  
                 System.out.println(annotationType);  
             }  
             System.out.println("hasAnnotation:"+visitor.hasAnnotation(Component.class.getName()));  
             System.out.println("hasMetaAnnotation:"+visitor.hasMetaAnnotation(Component.class.getName()));
		}  
	}  
}
