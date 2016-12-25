package com.sprint;

import com.sprint.domain.*;
public class Main {
	public static void main(String[] args) {
		//使用构建器实例化对象
		User user = new User.Builder("xxx@163.com", "155********", "root").build();
		System.out.println(user);
		user = new User.Builder("xxx@163.com", "155********", "root").userId(1000).build();
		System.out.println(user);
	}
}
