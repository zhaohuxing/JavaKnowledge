package com.sprint.bean;

import com.sprint.helloword.HelloApi;
public class HelloApiStaticFactory {
	public static HelloApi newInstance(String message) {
		return new HelloImp2(message);
	}
}
