package com.sprint.nested;

import com.sprint.interfaces.*;
public class InnerClassDemo2 {
	public static TestImp testDomain() {
		class LocalInnerClass implements TestImp {
			public void printf() {
				System.out.println("好困");	
			}

			@Override
			public String test() {
				System.out.println("通过内部类现实接口放出向上转型，有个弊端就是访问不到内部类新增的属性和方法!");
				return null;	
			}
		}
		return new LocalInnerClass();
	}
//	LocalInnerClass xxx = new LocalInnerClass();  error out of scope
	
	public static void defIfScopeInnerClass(boolean right) {
		if (right) {
			class Result {
				private int code = 200;
				@Override
				public String toString() {
					return "Result.code:" + code;
				}
			}
			Result result = new Result();
			System.out.println(result);
		} else {
			//Result result = new Result(); out of scope
			//System.out.println(result);
			System.out.println("Result.code:" + 404);
		}	
	}
}
