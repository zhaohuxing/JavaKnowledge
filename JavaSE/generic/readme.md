如果实现这个Iterable接口必须要实现:
```
//java.lang.Iterable
import java.util.Iterator;
    Iterator iterator();
```
然而如果实现Iterator接口，必须实现：
```
import java.util.Iterator;
    boolean hasNext();
    T next();
```

在`java.util.Collection`中实现了Iterable用于遍历集合里的数据，因为Iterator是接口，所有实例化其子类。
增强for的实现原理就是实现Iterable,Iterator接口完成遍历集合中的对象。
使用`javap -verbose 字节码文件`更进一步了解运行操作：
```
import java.util.List;
import java.util.ArrayList;
public class Test {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 4; i++) {
			list.add(i);
		}

		for (Integer i : list) {
			System.out.println(i);
		}

		Integer[] intArray = new Integer[]{1, 2, 3};
		for (int i : intArray)
			System.out.println(i);

	}

} 
```

![TestClass.jpg](http://upload-images.jianshu.io/upload_images/2031765-66b48df7a72e07c8.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

然而当用打印数组时 没有用到迭代，而是根据其下标取值。

###适配器模式
适配器模式,将一个类的接口转换成客户希望的另外一个接口.Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作．
![适配器模式的类结构.jpg](http://upload-images.jianshu.io/upload_images/2031765-51495ff943d094e5.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
<br>Target：所要转换的所期待的接口 <br> 
Adaptee：需要适配的类  <br>
Adapter：将源接口适配成目标接口，继承源接口，实现目标接口． <br>

**举个栗子：**
假如给你一个Fibonacci.java,要实现Iterable接口进行遍历。
```
package com.sprint.generics;

import com.sprint.utils.Generator;
public class Fibonacci implements Generator<Integer> {
	private int count = 0;

	@Override
	public Integer next() {
		return fib(count++);
	}

	private Integer fib(int n) {
		if (n < 2) return 1;
		return fib(n-1) + fib(n-2);
	} 
}
```
在实现需求的同时，我们要遵守`开闭原则`，只扩展，不修改。那么适配模式将是一种不错的策略，创建IterableFibonacci.java继承Ficbonacci,并实现Iterable接口。
```
package com.sprint.generics;

import java.util.Iterator;
public class IterableFibonacci 
extends Fibonacci implements Iterable<Integer> {
	private int n;
	
	public IterableFibonacci(int count) {
		n = count;
	}

	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			@Override
			public boolean hasNext() {
				return n > 0;	
			}

			@Override
			public Integer next() {
				n--;
				return IterableFibonacci.this.next();//继承父类的
			}
		};
	}
}
```
