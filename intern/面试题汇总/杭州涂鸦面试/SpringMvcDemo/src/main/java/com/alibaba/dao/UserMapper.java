/**
 * 
 */
package com.alibaba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.alibaba.model.SysMenu;
import com.alibaba.model.User;
import com.alibaba.model.easyui.PageHelper;

/**
 * @author tfj
 * 2014-8-2
 */
public interface UserMapper {

	public User findUserByName(@Param("username") String username);

	public String getUsernameById(@Param("id") int id);

	public List<SysMenu> getMenuByUserId(@Param("userId") int userId);
	
	public List<User> getDatagrid();

	public Long getDatagridTotal(User user);

	public List<User> datagridUser(PageHelper page);

	public void addUser(User user);

	public void editUser(User user);

}
