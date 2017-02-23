package com.sprint.ctrls;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LoginCtrl {

	@RequestMapping("/login")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if ("GET".equalsIgnoreCase(request.getMethod())) {
			return new ModelAndView("login");
		}
		//2. 非get请求提示登录
		String username = ServletRequestUtils.getStringParameter(request, "username");
		if ("root".equals(username)) { //root为正确的登录名
			//登录成功后将添加用户到cookie/session,而不是设置标志
			request.getSession().setAttribute("username", username);
			return new ModelAndView("loginSuccess");
			
		}
		//登录失败返回登录界面
		return new ModelAndView("login");
	}
}
