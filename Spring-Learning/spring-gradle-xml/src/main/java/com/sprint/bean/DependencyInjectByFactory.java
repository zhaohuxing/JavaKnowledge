package com.sprint.bean;

import com.sprint.helloword.HelloApi;
public class DependencyInjectByFactory {
	public HelloApi newInstance(String message, int index) {
		return new HelloImp3(message, index);
	}
}
