package com.sprint.util.maps;

public class Individual implements Comparable<Individual> {
	private static long counter = 0;
	private final long id = counter++;
	private String name;

	public Individual(String name) {
		this.name = name;
	}

	public Individual() {
	
	}

	public String toString() {//第10条: 必须覆盖toString()方法．用于返回该的类的信息
		return getClass().getSimpleName() + " " + name==null ? " " : " "+name;
	}

	public long id() {
		return id;
	}

	public boolean equals(Object o) {//第8条: 覆盖equals方法遵循通用约定 (instanceof  ==)
		return o instanceof Individual && id == ((Individual)o).id;
	}

	public int hashCode() {//第9条: 覆盖equals时总要覆盖hashCode
		int result = 17;
		result = 37*result + name.hashCode();
		result = 37*result + (int)id;
		return result;
	}
	
	public int compareTo(Individual arg) {
		String first = getClass().getSimpleName();
		String argFirst = arg.getClass().getSimpleName();
		int firstCompare = first.compareTo(argFirst);
		if (firstCompare != 0)
			return firstCompare;
		if (name != null && arg.name != null) {
			int secondCompare = name.compareTo(arg.name);
			if (secondCompare != 0)
				return secondCompare;
		}
		return (arg.id < id) ? -1 : (arg.id == id ? 0:1);
	}


}
