package com.sprint.util.sets;

import java.util.*;

public class TypesForSets {
	static <T> Set<T> fill(Set<T> set, Class<T> type) {
		try {
			for (int i = 0; i < 10; i++) {
				set.add(type.getConstructor(int.class).newInstance(i));
			}	
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return set;
	}

	public static <T> void test(Set<T> set, Class<T> type) {
		fill(set, type);
		fill(set, type);
		fill(set, type);
		System.out.println(set);
	}
}
