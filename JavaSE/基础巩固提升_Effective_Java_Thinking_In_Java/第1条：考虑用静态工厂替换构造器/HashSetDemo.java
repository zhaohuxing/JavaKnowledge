import java.util.*;
public class HashSetDemo {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		Random random = new Random(47);
		for (int i = 0; i < 10000; i++) {
			set.add(random.nextInt(30) + (1<<16));
		}
		System.out.println(set);
		Iterator iter = set.iterator();
		while (iter.hasNext()) {
			 System.out.print(((int)iter.next() - (1 << 16)) +" ");
		}
	}
}
