package com.sprint.util.maps;
import java.util.*;
public class Prediction {
	private static Random rand = new Random(47);
	private boolean shadow = rand.nextDouble() > 0.5;
	public String toString() {
		if (shadow) {
			return "Six more xxx";
		} else {
			return "Early Spring";
		}
	}
}
