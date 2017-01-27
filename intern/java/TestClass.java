public class TestClass {
	private static void testMethod() {
		System.out.println("testMethod");
	}

	public static void main(String[] args) {
		//null可以强制转换任意对象
		((TestClass)null).testMethod();
		//output:
		//	testMethod
	}
}
