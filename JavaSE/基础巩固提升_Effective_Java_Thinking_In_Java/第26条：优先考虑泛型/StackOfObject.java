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
