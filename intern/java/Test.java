class Value {
	public int i = 15;
}

public class Test {
	public static void main(String[] args) {
		Test t = new Test();
		t.first();
	}

	public void first() {
		int i = 5;//局部变量，作用不了方法外的值
		Value v = new Value();//局部变量（如上）， i = 15
		v.i = 25;
		second(v, i); //v(25) , 5
		System.out.println(v.i); //原以为v是second的val,其实不是这样的，当second结束后，val即结束了，v是first未执行second实例化的，而且并改变了值
	}

	public void second(Value v, int i) {
		i = 0;
		v.i = 20; // first中的V
		Value val = new Value();// 局部变量
		v = val;
		System.out.println(v.i + " " + i); // 15 0
	}
}
