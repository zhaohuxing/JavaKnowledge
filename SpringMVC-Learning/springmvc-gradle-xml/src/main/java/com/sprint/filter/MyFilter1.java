package com.sprint.filter;

import java.util.Enumeration;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.Filter; 
import javax.servlet.FilterConfig; 
import javax.servlet.FilterChain; 
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class MyFilter1 implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException{
		System.out.println("MyFilter1初始化");		
		System.out.println("FilterName:" + filterConfig.getFilterName());
		System.out.println("Filter所在的ServletContent:" + filterConfig.getServletContext());
		System.out.println("getInitParameter" + filterConfig.getInitParameter("pname"));

		for (Enumeration<String> str = filterConfig.getInitParameterNames(); str.hasMoreElements();) {
			System.out.println(str.nextElement());
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("我是MyFilter1,处理一系列请求");	
		chain.doFilter(request, response);
		System.out.println("我是MyFilter1,处理一系列响应");
	}

	@Override
	public void destroy() {
		System.out.println("MyFilter1初始化");	
	}
}
