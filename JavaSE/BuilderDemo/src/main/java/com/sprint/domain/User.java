package com.sprint.domain;

import java.io.Serializable;
import java.util.*;
public class User implements Serializable {
	public static final long serialVersionUID = 1L;

	private int id;
	private Date createTime;
	private Date updateTime;
	private int version;
	private long userId; 
	private String email; // 必选
	private String mobliePhoneNumber;//必须
	private String password; //必须
	private int status;
	
	public static class Builder {
		private int id;
		private Date createTime;
		private Date updateTime;
		private int version;
		private long userId; 
		private String email; // 必选
		private String mobliePhoneNumber;//必须
		private String password; //必须
		private int status;
		
		public Builder(String email, String mobliePhoneNumber, String password) {
			this.email = email;
			this.mobliePhoneNumber = mobliePhoneNumber;
			this.password = password;
		}

		public Builder id(int id) {
			 this.id = id;
			 return this;
		}

		public Builder createTime(Date createTime) {
			this.createTime = createTime;
			return this;
		}

		public Builder updateTime(Date updateTime) {
			this.updateTime = updateTime;
			return this;
		} 

		public Builder version(int version) {
			this.version = version;
			return this;
		}

		public Builder userId(long userId) {
			this.userId = userId;
			return this;
		}

		public Builder status(int status) {
			this.status = status;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}

	private User(Builder builder) {
		email = builder.email;
		mobliePhoneNumber = builder.mobliePhoneNumber;
		password = builder.password;
		id = builder.id;
		createTime = builder.createTime;
		updateTime = builder.updateTime;
		version = builder.version;
		userId = builder.userId;
		status = builder.status;
	}

	public void setId(int id) {
		this.id = id;
	} 

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setEmail(String email) {
		this.email = email;
	} 

	public void setMobliePhoneNumber(String mobliePhoneNumber) {
		this.mobliePhoneNumber = mobliePhoneNumber;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public int getVersion() {
		return version;
	}

	public long getUserId() {
		return userId;
	}

	public	String getEmail() {
		return email;
	}

	public String getMobliePhoneNumber() {
		return mobliePhoneNumber;
	} 

	public String getPassword() {
		return password;
	}

	public int getStatus() {
		return status;
	}

	@Override
	public String toString() {
		String data = "{\n\t\"id\":" + id +",\n" + "\t\"createTime\":" + createTime + ", \n" + "\t\"updateTime\":" + updateTime + ", \n"+ "\t\"version\":" + version + ", \n" + "\t\"userId\":" + userId + ", \n" + "\t\"email\":" + email + ", \n" + "\t\"mobliePhoneNumber\":" + mobliePhoneNumber + ", \n" + "\t\"password\":" + password + ",\n" + "\t\"status\":" + status  + "\n}";
		return data;
	}
}
