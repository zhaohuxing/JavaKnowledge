import java.util.List;
import java.util.ArrayList;
public class Test {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 4; i++) {
			list.add(i);
		}

		for (Integer i : list) {
			System.out.println(i);
		}

		Integer[] intArray = new Integer[]{1, 2, 3};
		for (int i : intArray)
			System.out.println(i);

	}

} 
