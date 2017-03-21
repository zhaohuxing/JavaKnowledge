package  com.sprint.enums;


import org.junit.Test;
public class EnumPlanetTest {
	@Test
	public void testPlanet() {
		double earthWeight = 175;
		double mass = earthWeight/Planet.EARTH.surfaceGravity();
		for (Planet p : Planet.values()) {
			System.out.printf("your weight on %s is %f%n", p, p.surfaceWeight(mass));
		}
	}
}
