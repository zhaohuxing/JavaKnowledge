package com.sprint.objectStream;

import java.io.*;
public class Bilp implements Externalizable {
	private int i;
	private String s;

	public Bilp() {
		System.out.println("Bilp 无参构造器");
	}
	
	public Bilp(String s, int i) {
		System.out.println("Bilp 有参构造器");
		this.i = i;
		this.s = s;
	}

	public String toString() { return s + i;} 
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Bilp writeExternal");
		out.writeObject(s);
		out.writeInt(i);
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("Bilp readExternal");
		s = (String)in.readObject();
		i = in.readInt();
	}
	

}
