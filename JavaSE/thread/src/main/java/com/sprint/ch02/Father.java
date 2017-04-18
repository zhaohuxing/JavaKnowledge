package com.sprint.ch02;

public class Father {
	public int i = 10;
	synchronized public void operateIMainMethod() {
		try {
			i--;
			System.out.println("father print i=" + i);
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
