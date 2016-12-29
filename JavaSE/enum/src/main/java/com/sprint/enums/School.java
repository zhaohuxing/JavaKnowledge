package com.sprint.enums;

public enum School{
	XXX, //要求每个元素都能不能相同，尽管构造方法不同也不行
	//XXX("海军航空工程大学", "芝罘区"), 与上行不能同时存在
	XXXX(),
	Ludong("鲁东大学", "芝罘区"),
	Yantai("烟台大学", "莱山区"),
	GongShang("山东工商学院", "莱山区"); //若在enum中添加属性和方法，则必须最后一个实例必须用；隔开
	private String name;
	private String position;
	private School(String name, String position) { //必须私有的
		this.name = name;
		this.position = position;
	}
	private School() {
	
	}

	public String getName() {
		return name;
	}

	public String getPosition() {
		return position;
	}

/*	@Override
	public String toString() {
		return name + ":enum也可以重写toString";
	}*/
}
