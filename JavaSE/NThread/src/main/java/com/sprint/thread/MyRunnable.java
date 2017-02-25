package com.sprint.thread;

public class MyRunnable implements Runnable {
	String name;
	public MyRunnable(String msg) {
		name = msg;
	}
	@Override
	public void run() {
		Thread.currentThread().setName(name);
		System.out.println(Thread.currentThread().getName() + "多线程运行");
	}
}
