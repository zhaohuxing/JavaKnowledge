class Main {
	public static void main(String[] args) {
		FinalDemo fd = new FinalDemo();
	}
}
public class FinalDemo {
	public static final int a = 2;
	public static final int b = 3;
	public final int c;

	static {
		System.out.println("static: a = " + a + ", b = " + b);
	}
	public FinalDemo() {
	//	b = 3; // 静态常量不能运行时初始化
		c = 4;
		System.out.println("constructor: a = " + a + ", b = " + b + ", c = " + c);
	}
	
}

