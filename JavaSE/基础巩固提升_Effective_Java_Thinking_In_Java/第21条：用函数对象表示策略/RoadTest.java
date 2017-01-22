public class RoadTest {
	private Car car;

	public RoadTest(Car car) {
		this.car = car;
	}

	public void test() {
		System.out.println("确认身份");	
		car.lightSimulate();
		car.otherProgram();
	}

	public static void main(String[] args) {
		RoadTest rt = new RoadTest(new CarOfJieda());
		rt.test();
	} 
}
