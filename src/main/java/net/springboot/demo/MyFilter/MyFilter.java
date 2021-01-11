package net.springboot.demo.MyFilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*自定义Filter
1）使用Servlet3.0的注解进行配置
2）启动类里面增加 @ServletComponentScan，进行扫描
3）新建一个Filter类，implements Filter，并实现对应的接口
4) @WebFilter 标记一个类为filter，被spring进行扫描 
	urlPatterns：拦截规则，支持正则

6）控制chain.doFilter的方法的调用，来实现是否通过放行
   不放行，web应用resp.sendRedirect("/index.html");
	场景：权限控制、用户登录(非前端后端分离场景)等*/

@WebFilter(urlPatterns = "/test/*",filterName = "loginFilter")
public class MyFilter implements Filter{

	/**功能描述：TODO
	 *
	 * 容器加载时调用
	 * <p> 创建时间：2021年1月2日 上午2:28:02 </p> 
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init loginFilter......");
		// TODO Auto-generated method stub
		
	}

	
	/**功能描述：TODO
	 *
	 * 请求被拦截调用
	 * <p> 创建时间：2021年1月2日 上午2:28:02 </p> 
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("do loginFilter......");
		
		HttpServletRequest request2 = (HttpServletRequest) request;
		HttpServletResponse response2 = (HttpServletResponse) response;
		String usernameString = request2.getParameter("username");
		
		if ("xdclass".equals(usernameString)) 	{
			chain.doFilter(request2,response2);
		}else {
			return ;
		}
		
		// TODO Auto-generated method stub
		
	}

	
	/**功能描述：TODO
	 *
	 * 容器被摧毁时调用
	 * <p> 创建时间：2021年1月2日 上午2:28:02 </p> 
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destory loginFilter......");
	}

}
