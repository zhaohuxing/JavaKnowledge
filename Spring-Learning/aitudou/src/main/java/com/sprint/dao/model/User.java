package com.sprint.dao.model;

public class User {
	private Long id;
	private String email;
	private String password;
	private String nickname;
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	} 

	public String getPassword() {
		return password;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	} 

	public String getNickname() {
		return nickname;
	}
}
