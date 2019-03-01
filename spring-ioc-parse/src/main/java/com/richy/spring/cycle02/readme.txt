Spring实例化bean的步骤(单例情况下):
	1、存在循环依赖的情况
		1.1、首先通过构造器实例化对象
		1.2、然后将对象对应的BeanFactory存放在SingletonBeanFactories中，以便下次或去
		1.3、然后填充属性
			1.3.1、在填充属性的时候，如果依赖的对象内部又有依赖本事，就从SingletonBeanFactories中获取BeanFactory，然后调用getObject()获取对象，设置进去
	
	所以，如果存在循环依赖，并且对象是通过构造器传入，就会报错：
		org.springframework.beans.factory.BeanCurrentlyInCreationException
		
	因此：如果想要实例化循环依赖的对象，必须前提是单例，而且不能通过构造器传入，只能通过属性传入
	
	Spring只为单例对象提供缓存，多例对象不提供缓存，因为单例全局就一个，而多例对象每次获取创建一个，因此不能提供缓存
，所以，因此没有缓存，那么就不支持多例对象的循环依赖