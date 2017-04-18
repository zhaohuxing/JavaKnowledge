package com.sprint.ch02;

public class Sub extends Father {
	synchronized public void operateISubMethod() {
		try {
		
			while (i > 0) {
				i--;
				System.out.println("sub print i=" + i);
				Thread.sleep(100);
				this.operateIMainMethod();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} 
}
