在Java中Object是所以对象的父类，可以利用Object进行类型转换，也可以借助泛型，往往借助泛型会安全些，避免了一下类型转化的异常。通过栗子来说明这个问题：

```
import java.util.Arrays;
import java.util.EmptyStackException;
public class StackOfObject {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public StackOfObject() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(Object obj) {
		ensureCapacity();
		elements[size++] = obj;
	}

	//第13条：使类和成员的访问性最小化
	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2*size +1);
		}
	} 

	public Object pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}

		Object result = elements[--size];
		elements[size] = null;
		return result;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public static void main(String[] args) {
		StackOfObject soo = new StackOfObject();
		soo.push(130);
	//	Integer n = (Integer)soo.pop();
		int n = (int)soo.pop();	
		System.out.println(n);
	}
}
```

借助Object数组实现了Stack，牵扯着类型的转化，所以使用泛型类来重构一下。

```
import java.util.EmptyStackException;
import java.util.Arrays;

public class StackOfGeneric<E> {
	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	//@SuppressWarnings("unchecked")
	public StackOfGeneric() {
		//elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}

	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2*size+1);
		}
	}

	public E pop() {
		if (size == 0)
			throw new EmptyStackException();
		E e = elements[--size];
		elements[size] = null;
		return e;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public static void main(String[] args) {
		//StackOfGeneric<Integer> sog = new StackOfGeneric<Integer>();
		//sog.push(3);
		//System.out.println(sog.pop());
	}
}
```

因为E是不确定类型，所以编译时报异常。针对这种情况有两种解决方案。<br />
一是：在构造器中new Object[CAPACITY]然后强制转化为E[].,这种做法是合法的，但是整体上不是类型安全的，所以要在构造器上添加@SuppressWarings("-unchecked")

```
@SuppressWarnings("unchecked")
public StackOfGeneric() {
    elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
}
```

二是：将E[]改为Object[]。这样需要在构造器中强制转化，而且在pop()也需要转化。

```
@SuppressWarnings("unchecked")
public StackOfGeneric() {
    elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
}

public E pop() {
    if (size == 0)
        throw new EmptyStackException();
    @SuppressWarnings("unchecked") E result = (E)elements[--size];
    elements[size] = null;
    return result;
}
```
禁止创建泛型数组，往往偏向于第二种解决策略。由于第二种多次转换所以第一种常用，所以只要设计类时用到泛型就行，避免硬编码的类型转化，对于解决方法，就看自己的选择了。
