package com.sprint.filter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class MyFilter2 implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		/*
		 *	init用于Filter初始化，由web容器来调用。仅调用一次。
		 *	filter配置被封装成filterConfig对象，以参数的方式被传进来了。
		 *	这里filter配置是指web.xml中的一系列filter标签。
		 *	后续会介绍用注解配置filter。
		 * */	
		System.out.println("MyFilter2初始化");
		System.out.println("FilterName:" + filterConfig.getFilterName());
		System.out.println("Filter所在的ServletContext:" + filterConfig.getServletContext());
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
							FilterChain filterChain) throws IOException, ServletException {
		System.out.println("我是MyFilter2,处理一系列请求");
		filterChain.doFilter(request, response);	
		System.out.println("我是MyFilter2,处理一系列响应");
	}

	@Override
	public void destroy() {
		/*
		 *	destroy()用于Filter销毁，由web容器调用.仅调用一次。
		 */	
		System.out.println("MyFilter2filter销毁");
	}
}
