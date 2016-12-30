package com.sprint.enums;

import java.util.*;
public class Mail {
	enum GeneralDelivery { YES, NO1, NO2, NO3, NO4, NO5}
	enum Scannablity { UNSCANNABLE, YES1, YES2, YES3, YES4}
	enum Readablity { ILLEGILE, YES1, YES2, YES3, YES4}
	enum Address { INCORRECT, OK1, OK2, OK3, OK4}
	enum ReturnAddress { MISSING, OK1, OK2, OK3, OK4}
	
	GeneralDelivery generalDelivery;
	Scannablity scannablity;
	Readablity readablity;
	Address address;
	ReturnAddress returnAddress;
	static long counter = 0;
	long id = counter++;
	
	@Override
	public String toString() {
		return "Mail:" + id;
	}

	public String details() {
		return toString() + ", GeneralDelivery:" + generalDelivery + ", Scannablity:" + scannablity + ", Readablity:" + readablity + ", Address:" + address + ", ReturnAddress:" + returnAddress;
	} 

	public static Mail randomMail() {
		Mail m = new Mail();
		m.generalDelivery = Enums.random(GeneralDelivery.class);
		m.scannablity = Enums.random(Scannablity.class);
		m.readablity = Enums.random(Readablity.class);
		m.address = Enums.random(Address.class);
		m.returnAddress = Enums.random(ReturnAddress.class);
		return m;
	}

	public static Iterable<Mail> generator(final int count) {
		return new Iterable<Mail>() {
			int n = count;
			public Iterator<Mail> iterator (){
				return new Iterator<Mail>() {
					public boolean hasNext() { return n-- > 0; } //打眼一看以为是lambda, 还纳闷多了-
					public Mail next() { return randomMail(); }
					public void remove() {}
				};
			}
		};	
	}
}
