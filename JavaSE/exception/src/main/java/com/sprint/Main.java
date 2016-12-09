package com.sprint;

import com.sprint.exception.*;

public class Main {
	public static void main(String[] args){
		try {
			throw new NullPointerException();
		} catch (Exception e) {
			System.out.println("执行Catch");
			throw new IllegalArgumentException();	
		} finally {
			String a = "a" + "b" + 1;
			String b = "ab1";
			System.out.println(a == b);
			throw new NullPointerException();
		}
	}
}
