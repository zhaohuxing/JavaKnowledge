package com.sprint.bean;

import com.sprint.helloword.HelloApi;
public class HelloImp4 implements HelloApi {

	private String message;
	private int index;

	public void setMessage(String message) {
		this.message = message;
	} 

	public void setIndex(int index) {
		this.index = index;	
	}

	@Override
	public void sayHello() {
		System.out.println("index:" + index + " ; message: " + message);
	}
}
