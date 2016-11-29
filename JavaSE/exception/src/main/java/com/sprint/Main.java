package com.sprint;

import com.sprint.exception.*;

public class Main {
	public static void main(String[] args) {
		TestDemo td = new TestDemo();
		try {
			td.inputValue("@");
		} catch (Exception e) {
			System.out.println("eee");
			System.out.println("eee" + Thread.currentThread().getName());
			throw new IllegalArgumentException();	
		} finally {
			System.out.println("当发生异常时，finally --> catch(异常)"); 
		}
	}
}
