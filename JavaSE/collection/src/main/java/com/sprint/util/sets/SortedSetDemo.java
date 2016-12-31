package com.sprint.util.sets;

import java.util.*;
public class SortedSetDemo {
	public static void test() {
		SortedSet<String> sortedSet = new TreeSet<String>();
		Collections.addAll(sortedSet, "one two three four five six seven eight".split(" "));
		System.out.println(sortedSet);
		String low = sortedSet.first();
		String high = sortedSet.last();
		System.out.println(low);
		System.out.println(high);
		Iterator<String> it = sortedSet.iterator();
		for (int i = 0; i <= 6; i++) {
			if (i == 3) 
				low = it.next();
		    if (i == 6) 
				high = it.next();
			else 
				it.next();
		}
		System.out.println(low);
		System.out.println(high);
		System.out.println(sortedSet.subSet(low, high));
		System.out.println(sortedSet.headSet(high));
		System.out.println(sortedSet.tailSet(low));
	}
}
