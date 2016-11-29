package com.sprint.exception;

public class TestDemo {
	public void inputValue(String value) throws Exception {
		if (value == "@") 
			throw new MyException();
		System.out.println("无异常输入");
	}
}
