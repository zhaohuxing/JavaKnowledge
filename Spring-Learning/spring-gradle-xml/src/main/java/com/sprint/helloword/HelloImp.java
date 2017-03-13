package com.sprint.helloword;

public class HelloImp implements HelloApi {
	
	@Override
	public void sayHello() {
		System.out.println("你好，世界！");
	}
}
