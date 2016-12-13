package com.sprint.objectStream;
import java.util.*;
import java.io.*;
public class Worm implements Serializable {
	private static Random rand = new Random(47);
	private Data[] d = {
		new Data(rand.nextInt(10)),
		new Data(rand.nextInt(10)),
		new Data(rand.nextInt(10))
	};
	private Worm next;
	private char c;

	public Worm(int i, char x) {
		System.out.println("Worm constructor:" + i);
		c = x;
		if (--i > 0) 
			next = new Worm(i, (char)(x+1));
	}

	public Worm() {
		System.out.println("Default constructor");
	}

	public String toString() {
		StringBuilder result = new StringBuilder(":");
		result.append(c);
		result.append("(");
		for (Data dat : d) 
			result.append(dat);
		result.append(")");
		if (next != null)
			result.append(next);
		return result.toString();
	}

}
