package com.sprint;

import com.sprint.domain.*;
import com.sprint.interfaces.*;
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

		//内部类与向上转型
		InnerClassDemo1 outer1 = new InnerClassDemo1();
		TestImp testImp = outer1.testImp();
		testImp.test();
		
		//局部内部类
		InnerClassDemo2.testDomain().test();		
		
		//任意作用域的内部类
		InnerClassDemo2.defIfScopeInnerClass(true);
		InnerClassDemo2.defIfScopeInnerClass(false);
		
		//匿名内部类
		System.out.println(InnerClassDemo3.getUser("x_zhaohu"));
		InnerClassDemo3.getTestImp("163.com").test();
		
		//利用内部类实现多重继承
		InnerClassDemo4 icd = new InnerClassDemo4(); 
		testD(icd);
		testE(icd.makeE());
	}

	public static void testD(D d) {}
	public static void testE(E e) {} 
}
