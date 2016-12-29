package com.sprint.enums;

import com.sprint.interfaces.*;
import java.util.*;
import static com.sprint.enums.Activity.*;
public class EnumMaps {
	public static  void testEnumMap() {
		EnumMap<Activity, Action> em = new EnumMap<Activity, Action>(Activity.class);	
		em.put(RUNNING, new Action() {
			@Override
			public void action() {
				System.out.println("丫们，跑步去呀");
			}
		});

		em.put(SWIMMING, new Action() {
			@Override
			public void action() {
				System.out.println("走下河去!");	
			}
		});

		em.put(PLAYING, new Action() {
			@Override
			public void action() {
				System.out.println("哈哈哈哈");
			}
		});

		for (Map.Entry<Activity, Action> e : em.entrySet()) {
			System.out.print(e.getKey() + " ");
			e.getValue().action();
		}
		
		try {
			em.get("PLAYING").action();	
		} catch (Exception e) {
		//	throw new NullPointerException();
		}
	}

}
