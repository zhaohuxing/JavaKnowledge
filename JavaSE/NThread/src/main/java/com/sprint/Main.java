package com.sprint;

import com.sprint.thread.*;
public class Main {
	public static void main(String[] args) {
		String msg = "匿名";
		MyThread myThread = new MyThread("myThread");
		Thread thread = new Thread(msg) {
			@Override
			public void run() {
				System.out.println("匿名Thread运行");
			}
		};
		thread.start();
		myThread.start();

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("匿名Runnable运行");
			}
		};
		Thread thread1 = new Thread(runnable);
		thread1.start();

		MyRunnable myRunnable = new MyRunnable("MyRunnable");
		Thread thread2 = new Thread(myRunnable);
		thread2.start();
	}
}
