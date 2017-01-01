package com.sprint.util.maps;

import java.util.*;
import java.lang.reflect.*;
public class SpringDetector {
	public static <T extends Groundhog> void detectSpring(Class<T> type) throws Exception {
		Constructor<T> ghog = type.getConstructor(int.class);
		Map<Groundhog, Prediction> map = new HashMap<Groundhog, Prediction>();

		for (int i = 0; i < 10; i++) {
			map.put(ghog.newInstance(i), new Prediction());
		}
		System.out.println("map= " + map);
		Groundhog gh = ghog.newInstance(3);
		System.out.println("Looking up prediction for " + gh);
		if (map.containsKey(gh))
			System.out.println(map.get(gh));
		else 
			System.out.println("该key 不存在");
	} 

	public static <T extends Groundhog> void detectSpring1() throws Exception {
		Map<Groundhog, Prediction> map = new HashMap<Groundhog, Prediction>();
		for (int i = 0; i < 10 ; i++) {
			map.put(new Groundhog2(i), new Prediction());
		}
		System.out.println("map=" + map);
		Groundhog gh = new Groundhog2(3);
		System.out.println("Looking up prediction for " + gh);
		if (map.containsKey(gh)) 
			System.out.println(map.get(gh));
		else
			System.out.println("该key 不存在");
	}
}
