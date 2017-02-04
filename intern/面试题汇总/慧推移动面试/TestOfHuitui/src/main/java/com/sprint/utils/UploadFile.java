/*package com.sprint.utils;

import com.sprint.service.*;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
//@WebServlet(urlPatterns="/uploadFile")
@MultipartConfig(fileSizeThreshold=1024*1024*2, maxFileSize=1024*1024*20, maxRequestSize=1024*1024*200,location="/temp")
public class UploadFile extends HttpServlet{
	
	@Autowired
	private	UserService userService;

	@RequestMapping(value="/uploadFile", method=RequestMethod.POST)
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException{
		// 处理请求中文乱码
		request.setCharacterEncoding("utf-8");
		// 接收上传文件的内容
		Part part = request.getPart("fileName");
		// 获取上传文件的真实名称
		String cd = part.getHeader("Content-Disposition");
		int index = cd.indexOf("filename=\"") + 10;
		String filename = cd.substring(index, cd.length() - 1);
		System.out.println(filename);	
	// 读取上传目录的绝对路径
//		String path = getServletContext().getRealPath("/upload");
		// 将上传文件进行保存
		userService.getAllByExcel(filename);	
		part.write("temp" + "/" + filename);					
	}

	@Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
		doPost(req, resp);
    }
}*/
