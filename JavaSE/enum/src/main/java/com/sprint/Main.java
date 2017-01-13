package com.sprint;

import com.sprint.interfaces.*;
import com.sprint.enums.*;
public class Main {
	public static void main(String[] args) {
		//enum中的常用的方法，具体查api吧
		for (School s : School.values()) {
		
			System.out.print(s + "'s index is:" + s.getDeclaringClass() + "  " + s.name() + s.ordinal());
			System.out.print(" " + s.compareTo(School.Yantai));
			System.out.print(" "+ s.equals(School.Yantai) + " ");
			System.out.println(s == School.Yantai);
		}

		for (School s : School.values()) {
			System.out.println(s);
			System.out.println(s.getName() +"属于烟台"+ s.getPosition());
		}

		//随机选取
		for (int i = 0; i < 5; i++) {
			System.out.println(Enums.random(Activity.class));
		}

		//使用接口组织枚举
		for (int i = 0; i < 5; i++) {
			for (Course course : Course.values()) {
				Food food = course.randomSelection();
				System.out.println(food);
			}
			System.out.println("----------");
		}

		//在enum中内嵌interface 使用接口组织枚举
		for (int i = 0 ; i < 5; i++) {
			SecurityCategory category = Enums.random(SecurityCategory.class);
			System.out.println(category + ":" + category.randomSelection());
		}

		//EnumSet集合
		EnumSets.testEnumSet();

		//EnumMap集合
		EnumMaps.testEnumMap();
		
		//常量栗子
		CarWash carWash = new CarWash();
		System.out.println(carWash);
		carWash.washCar();
		carWash.add(CarWash.Cycle.BASICWASH);
		carWash.add(CarWash.Cycle.BASICWASH);// 重复忽略
		System.out.println(carWash);
		carWash.washCar();

		//使用enum的职责链
		for (Mail mail : Mail.generator(10)) {
			System.out.print(mail.details());	
			PostOffice.handle(mail);
			System.out.println("******************");
		}

		System.out.println("测试当输出一个实例时，调用几次构造函数:");
		System.out.println(AccountType.FIXED);
	}
}
