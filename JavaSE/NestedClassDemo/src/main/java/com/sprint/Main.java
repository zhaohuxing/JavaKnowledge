package com.sprint;

import com.sprint.nested.*;
import com.sprint.nested.statics.*;
public class Main {
	public static void main (String[] args) {

		/*
		 * 在StaticNestedClass中可以存在static的属性或方法．
		 * 在StaticNestedClass中可以访问外围类中的static的属性或方法．
		 * 当外围类中的属性名或方法名一致时，采取就近原则
		 * */
		System.out.println("StaticNestedClass 方法测试如下：");
		
		//StaticNested创建时无须外围类的引用，实例化如下:
		StaticNestedDemo.InnerClass staticNestedObj = new StaticNestedDemo.InnerClass();
		staticNestedObj.show();

		/**
		 * 在InnerClass中不可以定义static的属性或方法
		 * 在InnerClass中可以透明访问所有的外围类的属性或方法，(含被static修饰的,即使被嵌套多层)
		 * 当外围类中的属性名或方法名一致时，采取就近原则
		 * */
		System.out.println("InnerClass 方法测试：");
		InnerClassDemo outer = new InnerClassDemo(); //　Inner Class 隐藏保留对外围类对象的引用，所以必须实例化外围类才能实例化内部类
		InnerClassDemo.InnerClass innerObj = outer.new InnerClass(); 
		innerObj.show();
	}
}
