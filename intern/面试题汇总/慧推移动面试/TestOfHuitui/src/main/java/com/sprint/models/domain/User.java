package com.sprint.models.domain;

import java.util.Date;
public class User {
	private int id;
	private Date createTime;
	private Date updateTime;
	private String name;
	private String address;
	private String birth;
	private String sex;

	public User() {}

	public User(int id, String name, String address, String birth, String sex) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.birth = birth;
		this.sex = sex;
	}

	public void setId() {
		this.id = id;
	}

	public int getId() {
		return id;
	}	

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setName(String name) {
		this.name = name;
	} 

	public String getName() {
		return name;
	} 

	public void setAddress(String address) {
		this.address = address;
	} 

	public String getAddress() {
		return address;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getBirth() {
		return birth;
	}

	public void setSex(String sex) {
		this.sex = sex;
	} 

	public String getSex() {
		return sex;
	}
}
