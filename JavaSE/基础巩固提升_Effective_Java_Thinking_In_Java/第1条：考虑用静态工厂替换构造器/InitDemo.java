public class InitDemo {
	public static void main(String[] args) {
		Student student = new Student("x_zhaohu", 21, "student");	
	}
}

class Person {
	public String name;
	public int age;
	private static int count = 3;	
	public String sex = "man";
	
	static {
		System.out.println("count:" + count + "Person 中的static代码块");
	}

	{
		System.out.println("sex:" + sex + "name:" + name + ", age = " + age + "Person 中的非static代码块");
		//成员初始化 > static > 非static > contructor 
	}
	public Person(String name, int age) {
		count++;
		this.name = name;
		this.age = age;
		System.out.println("sex:" + sex + "name:" + name + ", age = " + age + "Person 中的Constructor代码");
	}
	
}

class Student extends Person{
	private String identity;
	private String school = "xxx大学";
	private static int clazz = 1403;
	public Student(String name, int age, String identity) {
		super(name, age);
		this.identity = identity;
		System.out.println("school:" + school + "name:" + super.name + ", age = " + super.age + "identity:"+ identity +  "Student 中的Constructor代码");
	}

	static {
		System.out.println( "clazz:" + clazz+"Student 中的static代码块");
	}
	{
		System.out.println("school:" + school + "name:" + super.name + ", age = " + super.age + "identity:"+ identity +  "Student 中的非static代码块");
	}

}
