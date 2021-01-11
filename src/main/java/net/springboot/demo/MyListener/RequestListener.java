package net.springboot.demo.MyListener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;


/**功能描述：TODO
 *
 * <p> 创建时间：2021年1月2日 下午4:57:41 </p> 
 * 介：监听器介绍和Servlet3.0的注解自定义原生Listener监听器实战
 */
@WebListener        
public class RequestListener implements ServletRequestListener	{

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("======requestDestroyed======");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("======requestInitialized======");
	}

}
