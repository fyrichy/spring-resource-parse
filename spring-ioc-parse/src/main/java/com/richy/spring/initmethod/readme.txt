init-method方法的执行时间
	通过getBean("beanName")来获取bean对象
		首先对bean进行实例化
		进行属性的填充
		然后执行init-method方法
		然后返回bean实例化好的对象
		
		所以在拿到bean对象之前，就已经执行了init-method方法