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
		User u1 = new User("小明");
		User u2 = new User();
		if (u1.getName() != null || u2.getName() != null) {
			System.out.println("u1.getName() != null || u2.getName() != null");
		}
		if (u1.getName() != null | u2.getName() != null) {
			System.out.println("u1.getName() != null | u2.getName() != null");
		}

	}
}

class User {
	private String name; //共有类中访问方法而非公有域

	public User() {} 
	public User(String name) {
		this.name = name;
	} 
	public String getName() {
		return name;
	}
}
