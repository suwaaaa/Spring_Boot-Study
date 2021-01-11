package net.springboot.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**功能描述：TODO
 *
 *使用框架写会比较快
 *
 * <p> 创建时间：2021年1月2日 下午4:14:31 </p> 
 * 
 */
@WebServlet(name = "userServlet" , urlPatterns = "/api/custom")
public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.getWriter().print("custom servlet..");
		response.getWriter().flush();
		response.getWriter().close();
		
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		this.doGet(request, response);
	}
}
