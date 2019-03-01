AOP的实现原理：
	1、首先在xml配置文件中添加标签<aop:aspect-autoproxy/>表示支持AOP
	2、在即系xml配置文件时，会通过aspect-autoproxy找到AspectJAutoProxyBeanDefinitionParser解析器
	3、在AspectJAutoProxyBeanDefinitionParser解析器的内部在容器中注册了AnnotationAwareAspectJAutoProxyCreater,
		然而事情并非那么简单，通过查看AnnotationAwareAspectJAutoProxyCreater发现其间接实现了BeanPostProcessor接口，
		疑问：为什么实现了BeanPostProcessor就那么值得一提呢？暂且搁置，记住，这里已经注册了一个实现了BeanPostProcessor接口的实现类
		
	4、然后把目光转移到获取bean，也就是getBean("beanName")，
		该方法的实现大致原理：
			a、首选实例化对应的对象；
			b、进行初始化
				初始化里面有三个步骤：
					b.1、执行 wrappedBean = applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
						这里会遍历容器中注册所有的BeanPostProcessor实现类(直接实现或者间接实现)，
						然后执行BeanPostProcessor里面的postProcessBeforeInitialization(Object bean, String beanName)，这个步骤
						可以对bean进行代理类的创建(当然AOP的代理对象不是在这个步骤中实现的)
					
					b.2、invokeInitMethods(beanName, wrappedBean, mbd);
						执行配置文件中配置了<bean id="xx" class="xxxx" init-method="xxxxxxx"/>的init-method对应的方法
					
					b.3、执行 wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
						这里会遍历容器中注册所有的BeanPostProcessor实现类(直接实现或者间接实现)，
						然后执行BeanPostProcessor里面的postProcessAfterInitialization(Object bean, String beanName)，这个步骤
						可以对bean进行代理类的创建(而AOP代理对象就是这里进行创建的)
						
						详解次步骤：因为注册了AnnotationAwareAspectJAutoProxyCreater(属于BeanPostProcessor间接实现类)，所以在实例化
						bean的过程中，容器通过遍历注册的所有的BeanPostProcessor实现类，从而可以执行到postProcessAfterInitialization(Object bean, String beanName)
						，也就是在AnnotationAwareAspectJAutoProxyCreater父类AbstractAutoProxyCreator中的postProcessAfterInitialization(Object bean, String beanName)
						方法：
						  详细实现如下：
						  	if (bean != null) {
								Object cacheKey = getCacheKey(bean.getClass(), beanName);
								if (!this.earlyProxyReferences.contains(cacheKey)) {
									return wrapIfNecessary(bean, beanName, cacheKey);
								}
							}
							return bean;
							通过wrapIfNecessary(bean,beanName,cacheKey)中创建bean的代理对象，并初匹配好各种增强。
							
							
							
所以Spring的AOP实现原理
1、在xml配置文件中配置<aop:aspectj-autoproxy/>
2、注解版使用@EnableAspectAutoProxy
3、通过上述两种方式，注册了AnnotationAwareAspectAutoProxyCreater,
  (是一个特殊类，间接实现了BeanPostProcessor，是Spring提供的一个拓展类，可以在初始化bean的前后对bean进行
      自定义修改做拓展)
4、执行对应的postProcessAfterInitialization(Object bean, String beanName)进行代理的创建
5、实现了接口的
	使用JDK动态代理，通过改变proxy-target-class="true"可以改变强制使用CGLIB动态代理
  没有实现接口：
  	使用CGLIB动态代理，
  		CGLIB动态代理的
  			弊端：
  				无法给final修饰的方法进行增强
  			优点：
  				CGLIB底层使用开源的java字节码编辑类库(ASM操作字节码实现)，性能比JDK动态代理强




							