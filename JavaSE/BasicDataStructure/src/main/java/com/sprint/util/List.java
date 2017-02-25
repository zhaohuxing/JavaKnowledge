package com.sprint.util;

public interface List<E> extends Collection<E> {
	boolean add(E e); //1
	void add(int index, E element);
	boolean addAll(Collection<? extends E> c); //2
	boolean addAll(int index, Collection<? extends E> c);
	void clear(); //3
	boolean contains(Object o); //4
	boolean containsAll(Collection<?> c); //5
	boolean equals(Object o); //6
	E get(int index);
	int hasnCode(); //7 
	int indexOf(Object o); 
	boolean isEmpty(); //8
	Iterator<E> iterator(); //9
	int lastIndextOf(Object o);
	//ListIterator<E> listIterator();
	//ListIterator<E> listIterator(int index);
	E remove(int index); 
	boolean remove(Object o); //10
	boolean removeAll(Collection<?> c); //11
	boolean retainAll(Collection<?> c); //12
	E set(int index, E element);
	int size(); //13
	List<E> subList(int fromIndex, int toIndex);
	Object[] toArray(); //14
	<T> T[] toArray(T[] a); //15
}
