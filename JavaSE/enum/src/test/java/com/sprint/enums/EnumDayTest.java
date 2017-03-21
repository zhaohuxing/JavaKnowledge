package com.sprint.enums;

import org.junit.Test;
import org.junit.Assert;
public class EnumDayTest {
	public EnumDayTest() {}

	public void tellItLikeItIs(Day day) {
		switch(day) {
			case MONDAY: {
				System.out.println("Mondays is bad!");
				break;
			}
			case FRIDAY: {
				System.out.println("Fridays is better!");
				break;
			}
			case SATURDAY:
			case SUNDAY: {
				System.out.println("Weekend is best!");
				break;
			}
			default: {
				System.out.println("Mindays is so-so!");
				break;
			}
		}
	}

	@Test
	public void testEnumDay() {
		EnumDayTest edt = new EnumDayTest();
		edt.tellItLikeItIs(Day.MONDAY);
	} 
}
