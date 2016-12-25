package com.sprint.nested;

import com.sprint.domain.*;
import com.sprint.interfaces.*;
public class InnerClassDemo3 {
	public static User getUser(String username) {
		return new User(username) {
			//需要自己创建User,如果需要构造器的化,还需要自己创建．
			@Override
			public String toString() {
				return "username" + username;
			}
		};
	}		

	public static TestImp getTestImp(String xxx) {
		return new TestImp() {
			//对于接口,构造器我创建不了,参数我总能穿进去吧				
			@Override
			public String test() {
				System.out.println("匿名内部类有何用?" + xxx);
				return null;
			}
		};
	}
}
