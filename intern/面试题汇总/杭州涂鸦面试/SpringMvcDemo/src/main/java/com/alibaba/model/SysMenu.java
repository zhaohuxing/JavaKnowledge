/**
 * 
 */
package com.alibaba.model;


/**
 * @author tfj
 * 2014-8-1
 */
public class SysMenu {
	/**
	 * 菜单ID
	 */
	private int id;
	/**
	 * 菜单名称
	 */
	private String text;
	/**
	 * 父级菜单ID 0表示根节点
	 */
	private int parentId;
	/**
	 * 菜单顺序
	 */
	private String sequence;
	/**
	 * 菜单图标样式
	 */
	private String iconCls;	
	/**
	 * 菜单链接地址
	 */
	private String url;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
