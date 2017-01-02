package com.sprint.util.maps;

import java.util.*;
public class MapEntry<K, V> implements Map.Entry<K, V> {
	private K key;
	private V value;

	public MapEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public void setKey(K key) {
		this.key = key;
	} 

	public K getKey() {
		return key;
	}

	public V setValue(V value) {
		V result = this.value;
		this.value = value;
		return result;
	} 

	public V getValue() {
		return value;
	}

	public int hashCode() {
		return (key==null ? 0:key.hashCode()) ^ (value==null ? 0:value.hashCode());
	}

	public boolean equals(Object o) {
		if (!(o instanceof MapEntry))
			return false;
		MapEntry me = (MapEntry)o;
		return (key==null ? me.getKey() == null : key.equals(me.getKey())) && 
			(value==null ? me.getValue() == null : value.equals(me.getValue()));
	}
}
