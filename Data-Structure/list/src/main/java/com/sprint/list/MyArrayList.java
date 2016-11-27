package com.sprint.list;

import java.util.Iterator;
public class MyArrayList<AnyType> implements Iterable<AnyType> {
	//实现Iterable,在客户端不需要知道内部结构时使用，方便遍历．需要重写iterator()方法．
	
	/*MyArrayList默认数据长度10*/
	private static final int DEFAULT_CAPACITY = 10;

	/*记录MyArrayList中数据的个数*/
	private int theSize;

	/*利用泛型，数组声明元素类型及长度*/
	private AnyType[] theItems;

	/*在无参构造器里，通过clear()来定义空的表，默认长度10*/
	public MyArrayList() {
		clear();
	}

	/*初始化表的长度,　并为data开辟长度为10*/
	public void clear() {
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}

	/*获取表内容量*/
	public int size() {
		return theSize;
	}

	/*判读表是否为空*/
	public boolean isEmpty() {
		return size() == 0;	
	}
	
	/*通过下标获取表中的值*/
	public AnyType get(int idx) {
		if (idx < 0 || idx >= size())
			throw new ArrayIndexOutOfBoundsException();
		return theItems[idx];
	}

	/*设置索引为idx的data为newVal,并返回索引为idex的oldVal*/
	public AnyType set(int idx, AnyType newVal) {
		if (idx < 0 || idx >= size())
			throw new ArrayIndexOutOfBoundsException();
		AnyType old = theItems[idx];
		theItems[idx] = newVal;
		return old;
	}

	/**
	 * 为表中的元素申请newCapacity大小的空间
	 * 小技巧：
	 * 		泛型数组的创建初始化是违法的，
	 * 		所以创建一个泛型界限的数组，然后使用一个数组进行类型转换．
	 */
	public void ensureCapacity(int newCapacity) {
		if (newCapacity < theSize)
			return;
		AnyType[] old = theItems;
		theItems = (AnyType []) new Object[newCapacity];
		for (int i = 0; i < size(); i++) 
			theItems[i] = old[i];
	}
	
	/*调用add(idx, data)方法，将数据追加到表尾*/
	public boolean add(AnyType x) {
		add(size(), x);
		return true;
	}

	/*在表索引为idx处,放置数据x*/
	public void add(int idx, AnyType x) {
		if (theItems.length == size()) 
			ensureCapacity(size() * 2 + 1);
		for (int i = theSize; i > idx; i--)
			theItems[i] = theItems[i-1];
		theItems[idx] = x;
		theSize++;
	}

	/*删除表中索引为idx的数据，并返回索引为idx的数据*/
	public AnyType remove(int idx) {
		AnyType removedItem = theItems[idx];
		for (int i = idx; i < size() -1; i++) 
			theItems[i] = theItems[i+1];
		theSize--;
		return removedItem;
	}

	/*实现Iterable需要重写iterator方法，中实例化了ArrayListIterator*/
	@Override
	public java.util.Iterator<AnyType> iterator() {
		return new ArrayListIterator();	
	}
	
	/*内部类，实现了Iterator,必须实现hasNext(), next(); 作用: 遍历*/
	private class ArrayListIterator implements java.util.Iterator<AnyType> {
		/*用于遍历的索引*/
		private int current = 0;
		
		/*判断表中是否还有数据*/
		public boolean hasNext() {
			return current < size();
		}

		/*获取表中的next数据*/
		public AnyType next() {
			if (!hasNext()) 
				throw new java.util.NoSuchElementException();
			return theItems[current++];
		}

		/*调用外部类中的remove删除数据*/
		public void remove() {
			MyArrayList.this.remove(--current);
		}
	}
	/**
	 * 小结：
	 * 		1.表的创建
	 * 		2.表中元素的添加
	 * 		3.表中元素的删除
	 * 		4.通过索引获取表中的值
	 * 		5.设置索引为x的值
	 * 		6.拥有Iterator对象，方便遍历
	 *      知识扩充：内部类的使用，以及Iterator，Iterable的使用及内部实现．
	 */
}
