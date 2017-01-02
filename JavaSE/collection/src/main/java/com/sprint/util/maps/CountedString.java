package com.sprint.util.maps;

import java.util.*;
public class CountedString {
	private static List<String> created = new ArrayList<String>();//忘记声明static，导致实例化的都是一样的	
	private String s;
	private int id = 0;

	public CountedString(String str) {
		s = str;
		created.add(s);
		for (String s2 : created)
			if (s2.equals(s))
				id++;
	}

	public String toString() {
		return "String: " + s + " id: " + id + "hashCode:" + hashCode();
	}

	public int hashCode() {
		int result = 17;
		result = 37*result+s.hashCode();
		result = 37*result + id;
		return result;
	}

	public boolean equals(Object o) {
		return o instanceof CountedString && s.equals(((CountedString)o).s) && id == ((CountedString)o).id;
	}
}
