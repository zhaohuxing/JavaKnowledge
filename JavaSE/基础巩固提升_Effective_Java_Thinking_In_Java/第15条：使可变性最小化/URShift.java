public class URShift {
	public static void main(String[] args) {
		int i = -1;
		System.out.println(Integer.toBinaryString(i));
		i >>>= 10; // i 向右移动10位后将结果赋给　i
		System.out.println(Integer.toBinaryString(i));
		long l = -1;
		System.out.println(Long.toBinaryString(l));
		l >>>= 10;
		System.out.println(Long.toBinaryString(l));
		short s = -1;
		System.out.println(Integer.toBinaryString(s));
		s >>>= 10;
		System.out.println(Integer.toBinaryString(s));
		byte b = -1;
		System.out.println(Integer.toBinaryString(b));
		b >>>= 10;
		System.out.println(Integer.toBinaryString(b));
		System.out.println(Integer.toBinaryString(b>>>10));
		System.out.println(1<<16);	
	
		System.out.println(Integer.toBinaryString(65536));	
		System.out.println(Math.pow(2, 16));
		System.out.println(65536>>16);
	}
}
