package com.sprint.bean.details;

public class InnerBean {
	private String name;
	private int age;

	public InnerBean(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "name:" + name + " ,age:" + age;
	}
}
