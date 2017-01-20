public class Figure {
	enum Shape { RECTANGLE, CIRCLE };

	//Tag field - the shape of this Figure
	final Shape shape;
	
	double length;
	double width;

	double radius;

	Figure(double radius) {
		shape = Shape.CIRCLE;
		this.radius = radius;
	}

	Figure(double length, double width) {
		shape = Shape.RECTANGLE;
		this.length = length;
		this.width = width;
	}

	double area() {
		switch (shape) {
			case RECTANGLE:
				return length * width;
			case CIRCLE:
				return Math.PI * (radius * radius);
			default:
				throw new AssertionError();
		}
	}

	public static void main(String[] args) {
		Figure f1 = new Figure(5);
		System.out.println(f1.area());
		Figure f2 = new Figure(4, 5);
		System.out.println(f2.area());
	}
}
