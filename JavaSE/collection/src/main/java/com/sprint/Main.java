package com.sprint;

import java.util.*;
import com.sprint.util.sets.*;
import com.sprint.util.queues.*;
import com.sprint.util.maps.*;
public class Main {
	public static void main(String[] args) {
		/*list set queue 三者实现了Collection,而map中引用了Collection*/	
		/*set的操作*/
		TypesForSets.test(new HashSet<HashType>(), HashType.class);		
		TypesForSets.test(new LinkedHashSet<HashType>(), HashType.class);		
		TypesForSets.test(new TreeSet<TreeType>(), TreeType.class);		
		// tshings that is not work
		TypesForSets.test(new HashSet<SetType>(), SetType.class);		
		TypesForSets.test(new HashSet<TreeType>(), TreeType.class);
		TypesForSets.test(new LinkedHashSet<SetType>(), SetType.class);
		TypesForSets.test(new LinkedHashSet<TreeType>(), TreeType.class);
		try {
			TypesForSets.test(new TreeSet<SetType>(), SetType.class);	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			TypesForSets.test(new TreeSet<HashType>(), HashType.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		SortedSetDemo.test();
		//优先队列
		ToDoList toDoList = new ToDoList();
		toDoList.add("Empty trash", 4, 'C');
		toDoList.add("Feed Dog", 2, 'A');
		toDoList.add("Feed bird", 7, 'B');
		toDoList.add("Mow lawn", 3, 'C');
		toDoList.add("Water lawn", 1, 'A');
		toDoList.add("Feed Cat", 1, 'B');
		while (!toDoList.isEmpty())
			System.out.println(toDoList.remove());
		//Map
		AssociativeArray<String, String> map = new AssociativeArray<String, String>(6);
		map.put("sky", "blue");
		map.put("grass", "green");
		map.put("ocean", "dancing");
		map.put("tree", "tall");
		map.put("earth", "brown");
		map.put("sun", "warm");
		try {
			map.put("extra", "object");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Too many objects");
		}
		System.out.println(map);
		System.out.println(map.get("ocean"));
	}
}
