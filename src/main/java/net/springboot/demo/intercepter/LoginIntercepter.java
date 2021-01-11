package net.springboot.demo.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginIntercepter implements HandlerInterceptor{

	/* 进入controller方法之前，参数校验，查询数据库 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LoginIntercepter>>>>preHandle");
		
		String tocken = request.getParameter("access_tocken");
		if (tocken.isEmpty()) {
			response.getWriter().print("access_tocken不存在");
		}
		
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	
	/* 调用controller方法，视图渲染之前 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LoginIntercepter>>>>postHandle");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	/* 整个完成，进行资源清理 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LoginIntercepter>>>>afterCompletion");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	
}
