查看错误信息应该是说没有扫描到楼主的 Service，经过一番排查之后，楼主将错误定位到了包扫描的配置上，其实也就是 use-default-filters 配置的问题上。
Step 1：先看一下楼主的 SpringMVC 和 Spring 的配置文件中对包扫描的配置：

SpringMVC：
---------------------------------------------------------------------------------------------------------------
	<!-- 配置自动扫描的包 -->
    <context:component-scan base-package="com.mybatis.ssm" use-default-filters="false">
        <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>
---------------------------------------------------------------------------------------------------------------
Spring：
---------------------------------------------------------------------------------------------------------------
    <!-- 配置自动扫描的包 -->
    <context:component-scan base-package="com.mybatis.ssm" use-default-filters="false">
        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>
---------------------------------------------------------------------------------------------------------------

SpringMVC 主要就是来管理网站的跳转逻辑，所以在配置扫描的包时，使用 use-default-filters 属性，并设置为 false，即不使用默认的 Filter 进行扫描。

而 Spring 的配置文件中，楼主也想当然的配置了 use-default-filters 为 false，正式这个配置，导致出错。
Step 2：错误分析
	要分析这个错误，就要先了解 use-default-filters 这个属性的作用。
	use-default-filters 属性的默认值为 true，即使用默认的 Filter 
	进行包扫描，而默认的 Filter 对标有 @Service,@Controller和@Repository 
	的注解的类进行扫描，因为前面说过，我们希望 SpringMVC 只来控制网站的跳转逻辑，
	所以我们只希望 SpringMVC 的配置扫描 @Controllerce 注解标注的类，
	不希望它扫描其余注解标注的类，所以设置了 use-default-filters 为 false，
	并使用 context:include-filter 子标签设置其只扫描带有 @Controller 注解标注的类。


而 Spring 就不同了，我们希望 Spring 只不扫描带有 @Controller 注解标注的类，而扫描其他注解标注的类，而这时建立在使用默认的 Filter 进行扫描的基础上，设置了 context:exclude-filter 标签，不扫描 @Controller 注解标注的类，所以不应该设置 use-default-filters 为 false，所以这就解释了为什么一开始启动 Tomcat 时报了一个找不到 Service 的错误。
Step 3：总结
	在使用 use-default-filters 属性时要分清楚需要扫描哪些包，是不是
	需要使用默认的 Filter 进行扫描。楼主稍微总结一下，即 use-default-filters="false" 
	需要和 context:include-filter 一起使用，而不能和 context:exclude-filter 属性一起使用。

Step 4：更正

Spring 的配置文件中包扫描配置如下：
---------------------------------------------------------------------------------------------------------------
	<!-- 配置自动扫描的包 -->
    <context:component-scan base-package="com.mybatis.ssm">
        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>
---------------------------------------------------------------------------------------------------------------
    