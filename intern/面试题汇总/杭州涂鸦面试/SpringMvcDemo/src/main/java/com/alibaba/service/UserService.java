/**
 * 
 */
package com.alibaba.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.alibaba.dao.UserMapper;
import com.alibaba.model.SysMenu;
import com.alibaba.model.User;
import com.alibaba.model.easyui.DataGrid;
import com.alibaba.model.easyui.PageHelper;

/**
 * @author tfj
 * 2014-8-2
 */
/** 
 * Cacheable注解        负责将方法的返回值加入到缓存中 
 * CacheEvict注解     负责清除缓存(它的三个参数与@Cacheable的意思是一样的) 
 * ---------------------------------------------------------------------------------------------------------- 
 * value------缓存位置的名称,不能为空,若使用EHCache则其值为ehcache.xml中的<cache name="myCache"/> 
 * key--------缓存的Key,默认为空(表示使用方法的参数类型及参数值作为key),支持SpEL 
 * condition--只有满足条件的情况才会加入缓存,默认为空(表示全部都加入缓存),支持SpEL 
 * 该注解的源码位于spring-context-*.RELEASE-sources.jar中 
 * Spring针对Ehcache支持的Java源码位于spring-context-support-*.RELEASE-sources.jar中 
 * ---------------------------------------------------------------------------------------------------------- 
 */
@Service
public class UserService {

	@Resource
	private UserMapper userMapper;
	/**
	 * @param username
	 * @return
	 */
	public User findUserByName(String username) {
		return userMapper.findUserByName(username);
	}
	
	 //将查询到的数据缓存到myCache中,并使用方法名称加上参数中的userNo作为缓存的key  
    //通常更新操作只需刷新缓存中的某个值,所以为了准确的清除特定的缓存,故定义了这个唯一的key,从而不会影响其它缓存值  
    @Cacheable(value="myCache", key="#id")  
    public String getUsernameById(int id){  
        System.out.println("数据库中查到此用户号[" + id + "]对应的用户名为[" + userMapper.getUsernameById(id) + "]");  
        return userMapper.getUsernameById(id);  
    }

	/**
	 * 获取该用户权限的菜单
	 * @param userId
	 * @return
	 */
	public List<SysMenu> getMenu(int userId) {
		return userMapper.getMenuByUserId(userId);  
	}

	/**
	 * 获取用户总数
	 * @param user
	 * @return
	 */
	public Long getDatagridTotal(User user) {
		return userMapper.getDatagridTotal(user);  
	}

	/**
	 * 获取用户列表
	 * @param page
	 * @return
	 */
	public List<User> datagridUser(PageHelper page) {
		page.setStart((page.getPage()-1)*page.getRows());
		page.setEnd(page.getPage()*page.getRows());
		return userMapper.datagridUser(page);  
	}

	/**
	 * 新增用户
	 * @param user
	 */
	public void add(User user) {
		userMapper.addUser(user);  
	}

	/**
	 * 编辑用户
	 * @param user
	 */
	public void edit(User user) {
		userMapper.editUser(user);  
	}  
    
    
    
    
}
