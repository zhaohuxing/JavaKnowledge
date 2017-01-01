package com.sprint.util.maps;

import java.util.*;
public class SlowMap<K, V> extends AbstractMap<K, V> {
	private List<K> keys = new ArraysList<K>();
	private List<V> values = new ArraysList<V>();

	public V put(K key, V value) {
		V oldValue = get(key);
		if (!keys.contains(key)) {
			keys.add(key);
			values.add(value);
		} else {
			values.set(keys.indexOf(key), value);
		}
		return oldValue;
	}

	public V get(Object key) {
		if (!keys.contains(key))
			return null;
		return values.get(keys.indexOf(key));
	}
}
