package com.sprint.nested;

public class InnerClassDemo {
	public static int i = 1;
	public static void print() {
		System.out.println("Outer print() Method");
	}

	public class InnerClass {
		//public static int i = 8; Illegal static declaration in inner class. 
		public int a = 8; //right
		/**
		 * 在InnerClass中不可以定义static的属性或方法
		 * 在InnerClass中可以透明访问所有的外围类的属性或方法，(含被static修饰的,即使被嵌套多层)
		 * */
		public void show() {
			System.out.println(--InnerClassDemo.this.i); // 外围类的名.this 代表外围类对象的引用
			print();
		}
	}
}
