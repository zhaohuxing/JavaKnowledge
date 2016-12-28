package com.sprint.enums;

public enum School{
	Ludong("鲁东大学"),
	Yantai("烟台大学"),
	GongShang("山东工商学院");
	private String name;
	private String position;
	private School(String name, String position) {
		this.name = name;
		this.position = position;
	}
}
