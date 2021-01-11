package net.springboot.demo.MyListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**功能描述：TODO
*
* <p> 创建时间：2021年1月2日 下午4:57:41 </p> 
* 介：监听器介绍和Servlet3.0的注解自定义原生Listener监听器实战
*/


@WebListener
public class MyContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("====contextInitialized====");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("====contextDestroyed====");
	}

}
