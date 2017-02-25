package com.sprint.util;

public interface Iterable<T> {
	
	//default void forEach(Consumer<? super T> action)
	Iterator<T> iterator();	
	//defalut Spliterator<T> spliterator();
	//对于默认的方法，还不清楚其作用
}
