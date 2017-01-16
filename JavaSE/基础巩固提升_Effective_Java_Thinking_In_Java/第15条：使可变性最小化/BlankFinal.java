class Poppet {
	int i;
	Poppet(int ii) {
		i = ii;
	}
}

public class BlankFinal {
	private final int i = 0;
	private final int j;
	private final Poppet p;
	
	public BlankFinal() {
		j = 1;
		p = new Poppet(1);
		System.out.println(p);
	}

	public BlankFinal(int x) {
		j = x;
		p = new Poppet(x);
		System.out.println(p);
	}
	
	public void test() {
		try {
			//p = new Poppet(3); // 这句执行不了,不能编译
		} catch (Exception e) {
			System.out.println("被final修饰的引用不能更改");
		}
	}

	public void testFinalArgs(final Poppet po) {
		try {
		//	po = new Poppet(10); //都不能被编译
		} catch (Exception e) {
			System.out.println("被fianl修饰的参数不能方法内不允许被修改");
		}
	}

	public void testIAdd(final int i) {
		//	i++; //都不能被编译
	}
	/**被final修饰的引用，最晚必须在构造器里初始化，
	 * 所以构造器里的引用可以更改, 刚开始的时候有些不解
	 * 然而在方法中更改其引用就会报错error.
	 */
	public static void main(String[] args) {
		new BlankFinal();
		new BlankFinal(47);
		BlankFinal bf = new BlankFinal();
		bf.test();
		bf.testFinalArgs(new Poppet(5));
		bf.testIAdd(4);
	}
}
