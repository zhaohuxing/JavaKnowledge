import java.util.EmptyStackException;
import java.util.Arrays;
public class StackOfGeneric<E> {
	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public StackOfGeneric() {
		elements = new E[DEFAULT_INITIAL_CAPACITY];
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
		StackOfGeneric<Integer> sog = new StackOfGeneric<Integer>();
		sog.push(3);
		System.out.println(sog.pop());
	}
}
