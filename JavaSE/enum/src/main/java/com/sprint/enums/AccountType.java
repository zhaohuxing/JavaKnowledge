package com.sprint.enums;

public enum AccountType {
	SAVING, FIXED, CURRENT, INIT; //有几个实例就调用几次,因为static 所以在类加载时就初始化了，所以存在几个实例就调用几次构造函数
	private AccountType() {
		System.out.println("It is a account type");
	}

}
