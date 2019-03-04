package com.richy.spring.componentscan;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

import org.springframework.asm.ClassReader;
import org.springframework.core.NestedIOException;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.AnnotationMetadataReadingVisitor;
import org.springframework.util.ClassUtils;

/**
 * @descrp：包扫描工具，通过扫描传入的包路径，然后获取标注在类上面的信息
 * @author：FyRichy
 * @time：2019年3月4日上午9:23:34
 */
public class PackageComponentScan {

	static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";
	
	private Environment environment;
	
	private static final String resourcePattern = DEFAULT_RESOURCE_PATTERN;

	/**
	 * @descrp：通过包扫描解析类上面的注解
	 * @author：FyRichy
	 * @time：2019年3月4日上午10:03:35
	 * @param basePackage
	 * @throws Exception
	 */
	public void scanPackages(String basePackage) throws Exception {
		//解析包路径
		String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
				resolveBasePackage(basePackage) + '/' + this.resourcePattern;
		//根据当前的classLoader创建包路径解析器
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(Thread.currentThread().getContextClassLoader());
		//根据包路径解析并获取.class文件
		Resource[] resources = resolver.getResources(packageSearchPath);
		for(Resource resource:resources) {
			InputStream is = new BufferedInputStream(resource.getInputStream());
			ClassReader classReader;
			try {
				//创建ASM的ClassReader  
				classReader = new ClassReader(is);
			}
			catch (IllegalArgumentException ex) {
				throw new NestedIOException("ASM ClassReader failed to parse class file - " +
						"probably due to a new Java class file version that isn't supported yet: " + resource, ex);
			}
			finally {
				is.close();
			}
			//创建visitor
			AnnotationMetadataReadingVisitor visitor = new AnnotationMetadataReadingVisitor(Thread.currentThread().getContextClassLoader());
			//通过asm方式进行解析
			classReader.accept(visitor, ClassReader.SKIP_DEBUG);
			//获取到标注在类上面的注解
			Set<String> annotationSet = visitor.getAnnotationTypes();
			//类全限定名
			String className = visitor.getClassName();
			System.out.println("通过扫描，得到当前的类名称为："+className);
			//类的元注解(标注在类上面的注解的注解)
			for(String annotationName:annotationSet) {
				System.out.println("标注在当前类的上面的注解有："+annotationName);
				Set<String> getMetaAnnotationTypes = visitor.getMetaAnnotationTypes(annotationName);
				for(String metaAnnotationName:getMetaAnnotationTypes) {
					System.out.println("标注在当前类的上面的元注解有："+metaAnnotationName);
				}
			}
			
			/**
			 * 通过asm的方式解析类获取到注解，比通过反射调用获取注解的方式效率更高
			 * 
			 * 结果：
			 * 	通过扫描，得到当前的类名称为：com.richy.spring.handler.GlobalExceptionHandler
				标注在当前类的上面的注解有：com.richy.spring.annotation.ControllerAdvice
				标注在当前类的上面的元注解有：com.richy.spring.annotation.Component
				正是因为通过这种方式：
					然后通过判断，判断扫描到的类的元注解是否有@Component(com.richy.spring.annotation.Component)
					将com.richy.spring.handler.GlobalExceptionHandler纳入到Spring的容器中
			 */
		}
		
	}

	/**
	 * @descrp：解析包路径
	 * @author：FyRichy
	 * @time：2019年3月4日上午9:50:12
	 * @param basePackage
	 * @return
	 */
	private String resolveBasePackage(String basePackage) {
		return ClassUtils.convertClassNameToResourcePath(((AbstractEnvironment) getEnvironment()).resolveRequiredPlaceholders(basePackage));
	}

	/**
	 * @descrp：获取环境变量
	 * @author：FyRichy
	 * @time：2019年3月4日上午9:50:20
	 * @return
	 */
	private Object getEnvironment() {
		if (this.environment == null) {
			this.environment = new StandardEnvironment();
		}
		return this.environment;
	}
}
