public class CloneDemo {
	
	public static void main(String[] args) {
		Person p = new Person(2);
		Person p1 = p.clone();
	} 
}

class Person {
	private int id = 1;
	
	public Person() {}
	public Person(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public Person clone() {
		try {
			return (Person)super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}
}

