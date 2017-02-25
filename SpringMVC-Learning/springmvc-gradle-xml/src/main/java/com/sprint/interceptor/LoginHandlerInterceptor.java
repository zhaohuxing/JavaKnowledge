package com.sprint.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter {
	
	private String loginUrl;
	
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		//1.请求到登录页面放行
		if (request.getServletPath().startsWith(loginUrl)) {
			return true;	
		}

		//2.一些对外开放的url
		
		//3.如果用户登录，则放行
		if (request.getSession().getAttribute("username") != null) {
			//更好的实现使用cookie
			return true;
		}

		//4.非登录不能访问，重定向到访问页面
		response.sendRedirect(request.getContextPath() + loginUrl);
		return false;
	}
}
