package com.sprint;
import com.sprint.generics.coffee.*;
import com.sprint.generics.*;
import java.util.Iterator;
public class Main {

	public static void main(String[] args) {
		/*解释泛型的好处*/
		Holder1 hodler1 = new Holder1(new Automobile());
		System.out.println(hodler1.get());

		int sum = 0;
		//holder1 = new Holder1("不可以"); 报错
		Holder2 holder2 = new Holder2(1);
		System.out.println(holder2.get());
		sum+=(Integer)holder2.get(); // 使用Object策略时,需要强制转到合适的类型
		holder2 = new Holder2(2);
		System.out.println(holder2.get());
	
		Holder3<Integer> holder3 = new Holder3<Integer>();
		holder3.set(2);
		sum += holder3.get();
		//使用泛型时,事前需要指定类型，只好不需要强制转换.
		/*解释泛型的好处栗子结束*/
	
		/*简单元组类库TupleTest测试*/
		TwoTuple<String, Integer> ttsi = TupleTest.f();
		System.out.println(ttsi);	
		System.out.println(TupleTest.g());
		System.out.println(TupleTest.h());
		System.out.println(TupleTest.k());
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
