package com.sprint;
import com.sprint.generics.coffee.*;
import com.sprint.generics.*;
import java.util.Iterator;
public class Main {

	public static void main(String[] args) {
		/*有关coffee的Generics实现*/
		CoffeeGenerator gen = new CoffeeGenerator();
		for (int i = 0; i < 5; i++) {
			System.out.println(gen.next());
		}

		//增强for循环实现原理
		for (Coffee c : new CoffeeGenerator(5)) {
			System.out.println(c);			
		}

		//Fibonacci的Generator实现
		Fibonacci fib = new Fibonacci();
		for (int i = 0; i < 6; i++) {
			System.out.println(fib.next());
		}

		//通过适配器完成的Fibonacci，并测试Iterator
		System.out.println("IterableFibonacci================");
		IterableFibonacci ifi = new IterableFibonacci(6);
		Iterator iter = ifi.iterator();
		//Iterator遍历
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
