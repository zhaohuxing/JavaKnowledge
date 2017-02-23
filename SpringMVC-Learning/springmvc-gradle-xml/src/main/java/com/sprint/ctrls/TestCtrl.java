package com.sprint.ctrls;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class TestCtrl {
	
	@RequestMapping("/test")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("=========TestController");
		Thread.currentThread().sleep(1000);
		return new ModelAndView("test");
	} 
}
