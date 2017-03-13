package com.sprint.bean;

import com.sprint.helloword.HelloApi;
public class HelloApiFactory {
	public HelloApi newInstance(String message) {
		return new HelloImp2(message);
	}
}
