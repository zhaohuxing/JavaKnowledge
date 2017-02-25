package com.sprint.util;

public interface Collection<E> extends com.sprint.util.Iterable<E> {
	boolean add(E e); //1
	boolean addAll(Collection<? extends E> c); //2
	void clear(); //3
	boolean contains(Object o); //4
	boolean containsAll(Collection<?> c); //5
	boolean equals(Object o); //6
	int hasCode(); //7
	boolean isEmpty(); //8
	Iterator<E> iterator(); //9
	boolean remove(Object o); //10
	boolean removeAll(Collection<?> c); //11
	boolean retainAll(Collection<?> c); //12
	int size(); //13
	Object[] toArray(); //14
	<T> T[] toArray(T[] a); //15
}
