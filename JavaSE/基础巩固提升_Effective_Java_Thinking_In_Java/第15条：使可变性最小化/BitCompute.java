public class BitCompute {
	public static void main(String[] args) {
		System.out.println("按位&");
		System.out.println("1&1 = " + (1&1));
		System.out.println("1&0 = " + (1&0));
		System.out.println("0&1 = " + (0&1));
		System.out.println("0&0 = " + (0&0));
		System.out.println("按位|");
		System.out.println("1|1 = " + (1|1));
		System.out.println("1|0 = " + (1|0));
		System.out.println("0|1 = " + (0|1));
		System.out.println("0|0 = " + (0|0));
		System.out.println("按位^");
		System.out.println("1^1 = " + (1^1));
		System.out.println("1^0 = " + (1^0));
		System.out.println("0^1 = " + (0^1));
		System.out.println("0^0 = " + (0^0));
			
		if (21 != 21 && (100 /0 == 0)) {
			System.out.println("&&运算没有问题");
		} else {
			System.out.println("&&运算有问题");
		}

		if (21 == 21 || (100 / 0 == 0)) {
			System.out.println("||运算没有问题");
		} else {
			System.out.println("||运算有问题");
		}
		
		/* &&与|| 只要前者满足情况，就不在检测，　&与|都需要检测的*/
		if (21 != 21 & (100 / 0) == 0) { // ArithmeticException
			//...
		}

		
		if (21 == 21 | (100 / 0 == 0)) { // ArithmeticException
			//...
		}
	}
}
