package com.sprint.nested.statics;

public class StaticNestedDemo {
	private static int i = 5;
	public static void print() {
		System.out.println("Outer print() Method");	
	}

	public static class InnerClass {
		/*
		 * 在StaticNestedClass中可以存在static的属性或方法．
		 * 在StaticNestedClass中可以访问外围类中的static的属性或方法．
		 * 当外围类中的属性名或方法名一致时，采取就近原则
		 * */
		private static int i = 8;
		
	  /*public void print() {
			System.out.println("StaticNestedClass print() Method");
		}
      */
		public	void show() {
			print();
			System.out.println(--i);
		}
	}
}
