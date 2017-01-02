package com.sprint;

import java.util.*;
import com.sprint.util.sets.*;
import com.sprint.util.queues.*;
import com.sprint.util.maps.*;
public class Main {
	public static void main(String[] args) throws Exception {
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
		SpringDetector.detectSpring(Groundhog.class);
		System.out.println("====================");
		SpringDetector.detectSpring1();
		
		//测试用ArrayList写的SlowMap
		SlowMap<String, String> sm = new SlowMap<String, String>();
		for (int i = 1; i < 10; i++) {
			sm.put("keys"+i, "values"+i);
		}
		System.out.println(sm);
		Iterator iterator = sm.entrySet().iterator();
		Map.Entry element = (Map.Entry)iterator.next();
		System.out.println(element.getValue());
		/*遍历Map的方法
		 *	Map<String, String> map = new HashMap<String, String>();
		 *	1. Iterator iterator  = map.keySet();
		 *	while (iterator.hasNext()) {
		 *		String key = (String)iterator.next();
		 *		String value = (String)map.get(key);
		 * }
		 *
		 * 2. Iterator iterator = map.entrySet().iterator();
		 * while (iterator.hasNext()) {
		 * 		Map.Entry element = iterator.next();
		 * 		String key = (String)element.getKey();
		 * 		String value = (String)element.getValue();
		 * }
		 *
		 * */
		System.out.println("===========================");	
		//模拟通过计算散列码获取key索引，获取value的
		SimpleHashMap<String, String> shm = new SimpleHashMap<String, String>();
		for (int i = 1; i < 10; i++) {
			shm.put("keys"+i, "values"+i);
		}
		System.out.println(shm);
		Iterator iterator1 = shm.entrySet().iterator();
		Map.Entry element1 = (Map.Entry)iterator1.next();
		System.out.println(element1.getValue());

		//测试String的hashcode();
		String str = "hello";
		String str1 = new String("hello");
		System.out.println("String中如果内容一样，将指向同一块内存" + (str.hashCode() == str1.hashCode()));
			
		//遵循重写hashCode()的规范的栗子
		Map<CountedString, Integer> mapCS = new HashMap<CountedString, Integer>(); 
		CountedString[] cs = new CountedString[5];
		for (int i = 0; i < cs.length; i++) {
			cs[i] = new CountedString("hi");
			mapCS.put(cs[i], i);
		}
		System.out.println(mapCS);
		for (CountedString csString : cs) {
			System.out.println("Looking up " + csString);
			System.out.println(mapCS.get(csString));
		}
	}
}
