import java.util.*;
public class TreeSetDemo {
	
	public static void main(String[] args) {
		//TreeSet实现了SortedSet接口,SortedSet实现了Set接口
		Random rand = new Random(47);
		SortedSet<Integer> set = new TreeSet<Integer>(); //TreeSet将元素存储在红黑树中.
		for (int i = 0; i < 10000; i++) {
			set.add(rand.nextInt(30) + (1<<16));
		}
		System.out.println(set);	
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println((int)iterator.next() - (1<<16) + " ");
		}

		System.out.println(2<<16); // 1 << 16 == ( 2^1 )^15
		System.out.println(Math.pow(2, 16) -1);
		System.out.println(2<<3);
	}
}
