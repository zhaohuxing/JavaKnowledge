package com.sprint.bean;

import com.sprint.helloword.HelloApi;
/**
 * 通过无参构造器创建Bean
 * 通过有参构造器创建Bean
 */
public class HelloImp2 implements HelloApi {
	private String message;
	public HelloImp2() {
		this.message = "Hello World";
	}
	public HelloImp2(String message) {
		this.message = message;
	}
	@Override
	public void sayHello() {
		System.out.println(message);
	}
}
