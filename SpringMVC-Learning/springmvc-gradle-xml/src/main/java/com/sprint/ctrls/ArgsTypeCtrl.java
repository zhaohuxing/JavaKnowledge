package com.sprint.ctrls;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.io.Reader;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
@Controller
public class ArgsTypeCtrl {
	
	@RequestMapping(value="/argsType", method=RequestMethod.GET)
	@ResponseBody
	public String argsMethod(ServletRequest request, ServletResponse response,
								HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		System.out.println(httpRequest.getMethod());
		System.out.println(httpRequest.getParameter("name"));

		return "潜心修炼";
	}

	@RequestMapping(value="/argsType1", method=RequestMethod.GET)
	@ResponseBody
	public String argsMethod1(InputStream requestBodyIn, OutputStream requestBodyOut,
								Writer writer, Reader reader) {
		// requestBodyIn == request.getInputStream();
		// requestBodyOut == request.getOutputStream();
		// writer == request.getWriter();
		// reader = request.getReader();
		// InputStream/OutputStream　与 Writer/Reader不能同时使用，只能选择其中的一组
		return "success";	
	}

	@RequestMapping(value="/argsType2", method=RequestMethod.GET)
	@ResponseBody
	public String argsMethod2(WebRequest webRequest,NativeWebRequest nativeWebRequest) {
		//今天头一次见这组类, SpringMVC提供的统一访问类
		//不仅可以访问请求相关的数据，还可以访问会话和上下文中的数据
		//NativeWebRequest继承WebRequest.并提供访问Servlet API的方法。

		return "success";
	}

	//总结：
	//	然而平时HttpServletRequest/HttpServletResponse 居多，再者就是注解啦，
	//	其余的，如果往后工作中用到，再进一步学习吧！
	

	//******************注解式参数绑定***************************

	/*@RequestParam用于单个参数绑定*/
	@RequestMapping(value="/argsType3", method=RequestMethod.GET)
	@ResponseBody
	public void annotationArgs(@RequestParam("username") String name) {
		System.out.println(name);	
		//@RequestParam(value="username"), 表示：前台传过来的参数Name必须是username.
	}

	/*@PathVariable用于绑定URI模板值*/
	@RequestMapping(value="/argsType4/{args}", method=RequestMethod.GET)
	@ResponseBody
	public void annotationArgs1(@PathVariable("args") String args) {
		System.out.println(args);
	}

	/*@ModelAttribute用于绑定命令行对象*/
	@RequestMapping(value="/argsType5", method=RequestMethod.GET)
	@ResponseBody
	public void annotationArgs2(@ModelAttribute("user") User user) {
		System.out.println(user.getUsername() + "&" + user.getPassword() );		
	}

	@RequestMapping("/testx")
	public void testx(@RequestParam("name") String name, @RequestParam(value="age", required=false) Integer age) {
		System.out.println(name);
		System.out.println(age);
	} 


	@RequestMapping(value="/paths/{id}")
	public void testPath(@PathVariable(name="ids", required=false) Integer id) {
		// /{id} == id参数名要对应
		System.out.println(id);
	}

	@RequestMapping(value="/pathss/{xxx}")
	public void testPaths(@PathVariable(name="xxx", value="sss") int xxx) {
		
	}


	@RequestMapping(value="/model")
	public void testModel(@ModelAttribute("users") User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
	}
	@ResponseBody
	@RequestMapping(value="/requestbody", method=RequestMethod.POST)
	public void testReq(HttpServletRequest request, HttpServletResponse response) {
		String name = (String)request.getParameter("username");
		System.out.println(name);
	}

	@ResponseBody
	@RequestMapping(value="/work", method=RequestMethod.POST)
	public void work(@RequestBody User user) {
		System.out.println(user.getUsername());
	}
}
