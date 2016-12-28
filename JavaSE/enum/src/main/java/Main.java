package com.sprint;

import com.sprint.enums.*;
public class Main {
	public static void main(String[] args) {
		for (School s : School.values()) {
			System.out.print(s + "'s index is:" + s.getDeclaringClass() + "  " + s.name() + s.ordinal());
			System.out.print(" " + s.compareTo(School.Yantai));
			System.out.print(" "+ s.equals(School.Yantai) + " ");
			System.out.println(s == School.Yantai);
		}
	}
}
