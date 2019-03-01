SpringAOP源码解析

详解：proxy-target-class和expose-proxy
1、proxy-target-class：
	如果<aop:config proxy-target-class="true"/>强制使用CGLIB代理
	如果<aop:config proxy-target-class="false"/>或者忽略，则使用JDK动态代理
	默认使用JDK动态代理
	
2、expose-proxy：一言难尽