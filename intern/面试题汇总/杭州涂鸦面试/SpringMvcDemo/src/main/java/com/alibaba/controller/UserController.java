/**
 * 
 */
package com.alibaba.controller;


import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.model.User;
import com.alibaba.model.easyui.DataGrid;
import com.alibaba.model.easyui.Json;
import com.alibaba.model.easyui.PageHelper;
import com.alibaba.service.UserService;

/**
 * @author tfj
 * 2014-8-23
 */
@Controller
public class UserController {
	private final Logger log = LoggerFactory.getLogger(UserController.class);
	@Resource
	private UserService userService;
	
	/**
	 * 跳转到用户表格页面
	 * @return
	 */
	@RequestMapping(value = "/user/list",method = RequestMethod.GET)
    public String userList(Model model) {
        return "user/list";
    }
	
	/**
	 * 用户表格
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/user/datagrid", method = RequestMethod.POST)
	public DataGrid datagrid(PageHelper page,User user) {
		DataGrid dg = new DataGrid();
		dg.setTotal(userService.getDatagridTotal(user));
		
		List<User> userList = userService.datagridUser(page);
		dg.setRows(userList);
		
		return dg;
	}
	
	/**
	 * 新增用户
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/user/addUser",method = RequestMethod.POST)
    public Json addUser(User user) {
		Json j = new Json();
		
		try {
            userService.add(user);
            j.setSuccess(true);
            j.setMsg("用户新增成功！");
            j.setObj(user);
        } catch (Exception e) {
            j.setMsg(e.getMessage());
        }
        return j;
    }
	
	/**
     * 修改用户
     * 
     * @param user
     * @return
     */
	@ResponseBody
    @RequestMapping(value = "/user/editUser",method = RequestMethod.POST)
    public Json editUser(User user) {
        Json j = new Json();
        log.debug("穿过来的用户ID为："+user.getId());
        try {
            userService.edit(user);
            j.setSuccess(true);
            j.setMsg("编辑成功！");
            j.setObj(user);
        } catch (Exception e) {
            // e.printStackTrace();
            j.setMsg(e.getMessage());
        }
        return j;
    }
}
