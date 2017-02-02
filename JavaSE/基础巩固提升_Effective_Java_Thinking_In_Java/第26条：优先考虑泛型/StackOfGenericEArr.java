import java.util.EmptyStackException;
import java.util.Arrays;
public class StackOfGenericEArr<E> {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	@SuppressWarnings("unchecked")
	public StackOfGenericEArr() {
		elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY]; 
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
		@SuppressWarnings("unchecked")	E result = (E)elements[--size];
		elements[size] = null;
		return result;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	public static void main(String[] args) {
		StackOfGenericEArr<Integer> sogea = new StackOfGenericEArr<Integer>();
		sogea.push(2);
		System.out.println(sogea.pop());
	}
}
