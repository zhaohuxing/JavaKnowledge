package com.sprint.nested;

import com.sprint.interfaces.*;
public class InnerClassDemo1 {
	private class InnerClass implements TestImp {
		@Override 
		public String test() {
			System.out.println("this is InnerClass's test() Method");
			return null;
		}
		
	}

	public TestImp testImp() {
		return new InnerClass();
	}
}
