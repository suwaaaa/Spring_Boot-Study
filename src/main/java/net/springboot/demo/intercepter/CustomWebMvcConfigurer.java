package net.springboot.demo.intercepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*Filter
是基于函数回调 doFilter()，而Interceptor则是基于AOP思想
Filter在只在Servlet前后起作用，而Interceptor够深入到方法前后、异常抛出前后等

依赖于Servlet容器即web应用中，而Interceptor不依赖于Servlet容器所以可以运行在多种环境。

在接口调用的生命周期里，Interceptor可以被多次调用，而Filter只能在容器初始化时调用一次。

Filter和Interceptor的执行顺序
	
过滤前->拦截前->action执行->拦截后->过滤后*/

@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {   //   registry是注册拦截器的一个类
		// TODO Auto-generated method stub
		
		registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/intercepter/*/**");  // 和拦截该路径的所有方法
		WebMvcConfigurer.super.addInterceptors(registry);
	}

	
}
