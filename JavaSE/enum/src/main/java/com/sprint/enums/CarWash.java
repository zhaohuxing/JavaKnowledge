package com.sprint.enums;
import java.util.*;
public class CarWash {
	public enum Cycle {
		ALLWASH {
			@Override
			public void action() {
				System.out.println("全清洗");
			} 
		},
		PREWASH {
			@Override
			public void action() {
				System.out.println("清洗前身");
			}
		},
		BASICWASH {
			@Override
			public void action() {
				System.out.println("大体洗洗");
			}
		},
		WHEELWASH {
			@Override
			public void action() {
				System.out.println("清洗轮胎");
			}
		};
		public abstract void action();
	}
	public EnumSet<Cycle> cycles = EnumSet.of(Cycle.PREWASH, Cycle.WHEELWASH);
	public void add(Cycle cycle) {
		cycles.add(cycle);
	} 
	public void washCar() {
		for (Cycle c : cycles) {
			c.action();
		}
	} 

	@Override
	public String toString() {
		return cycles.toString();
	}
}
