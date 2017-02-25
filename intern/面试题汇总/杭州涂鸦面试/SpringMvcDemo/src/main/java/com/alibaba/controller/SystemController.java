/**
 * 
 */
package com.alibaba.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.model.SysMenu;
import com.alibaba.model.User;
import com.alibaba.model.easyui.Tree;
import com.alibaba.service.UserService;
import com.alibaba.util.RequestUtil;

/**
 * @author tfj
 * 2014-7-26
 */
@Controller
public class SystemController {
	private final Logger log = LoggerFactory.getLogger(SystemController.class);
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String home() {
		log.info("返回首页！");
		return "index";
	}
	
	@RequestMapping(value = "/test/hello",method = RequestMethod.GET)
    public String testHello(@RequestParam String test) {
    	log.info("执行了testHello方法！");
    	log.info(test);
        return "loginSuccess";
    }
	
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String testLogin(HttpServletRequest request,@RequestParam String username, @RequestParam String password) {
    	log.info("执行了testLogin方法！");
    	User user = userService.findUserByName(username);
    	if(user!=null){
//    		log.info("user在数据库的密码是："+user.getPassword());   
//    		log.info("登录时输入加密的密码是："+DigestUtils.md5Hex(password));   
    		if(user.getPassword().equals(DigestUtils.md5Hex(password))){
    			request.getSession().setAttribute("userId", user.getId());  
    			request.getSession().setAttribute("user", username);  
        		return "redirect:" + RequestUtil.retrieveSavedRequest();//跳转至访问页面
    		}else{
    			log.info("密码错误");  
        		request.getSession().setAttribute("message", "用户名密码错误，请重新登录");
        		return "login"; 
    		}
    	}else{
    		log.info("用户名不存在");  
    		request.getSession().setAttribute("message", "用户名不存在，请重新登录");
    		return "login"; 
    	}
    }
    
    /**
     * 测试缓存
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value="/get/{id}", method = RequestMethod.GET)  
    public String get(@PathVariable int id, Model model){  
        String username = userService.getUsernameById(id);  
        model.addAttribute("username", username);  
        return "getUsername";  
    } 
    
    /**
     * 获取菜单栏
     * @param id
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/getMenu", method = RequestMethod.POST)  
    public List<Tree> getMenu(HttpSession session){  
    	int userId =  (Integer)session.getAttribute("userId"); 
    	List<SysMenu> menuList = userService.getMenu(userId);
    	List<Tree> treeList = new ArrayList<Tree>();

        for (SysMenu menu : menuList) {
			Tree node = new Tree();
			BeanUtils.copyProperties(menu, node);
			if(menu.getParentId()!=0){	//有父节点
				node.setPid(menu.getParentId());
			}
			Map<String, Object> attr = new HashMap<String, Object>();
			attr.put("url", menu.getUrl());
			node.setAttributes(attr);
			treeList.add(node);
        }
    	return treeList;
    }
    

}
