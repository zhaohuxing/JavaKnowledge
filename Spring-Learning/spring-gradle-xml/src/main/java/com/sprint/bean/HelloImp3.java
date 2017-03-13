package com.sprint.bean;

import com.sprint.helloword.HelloApi;
public class HelloImp3 implements HelloApi {
	private String message;
	private int index;
	public HelloImp3(String message, int index) {
		this.message = message;
		this.index = index;
	}

	@Override
	public void sayHello() {
		System.out.println("index: " + index + ";message: " + message);
	}
}
