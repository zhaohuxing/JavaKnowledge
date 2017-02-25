package com.sprint.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StopWatchHandlerInterceptor extends HandlerInterceptorAdapter {
	
	private long beginTime;
	private long endTime;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		beginTime = System.currentTimeMillis();//开始时间
		return true;//继续流程
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		endTime = System.currentTimeMillis();//2.结束时间
		long consumeTime = endTime - beginTime; //3.消耗时间
		if (consumeTime > 500) { //此处认为处理时间超时
			//记录到日志文件
			System.out.println(String.format("%s consume %d mills", request.getRequestURI(), consumeTime));
		}
	}
}
