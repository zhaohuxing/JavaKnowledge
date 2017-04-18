package com.sprint.ch01;

public class MyThread extends Thread {

	@Override
	 public void run() {
		super.run();
			System.out.println("run begin");
//			Thread.sleep(200000);
			System.out.println("run end");
	 }
}
