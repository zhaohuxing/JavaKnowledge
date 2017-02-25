package com.sprint.thread;

public class MyThread extends Thread {

	public MyThread(String msg) {
		super(msg);
	}
	@Override
	public void run() {
		System.out.println(super.getName() + "中多线程输出");
	}
}
