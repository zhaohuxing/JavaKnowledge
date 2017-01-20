有时候，可能遇到两种或更多种风格实例的类，并包含表示实例风格的标签域。这时应考虑使用层次化进行重构。为了加深理解标签类，详情请看Figure.java。
```
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
```
标签类那种代码风格，过于冗长，容易出错，并且效率低下，并且这种风格的代码很少有适用的时候，这时候我们用使用层次化实现如上Figure.java。详情请看代码。
```
public abstract class AbstractFigure {
	abstract double area();
}

public class Circle extends AbstractFigure {
	final double radius;

	Circle(double radius) {
		this.radius = radius;
	}

	@Override
	double area() {
		return Math.PI * (radius * radius);	
	}
}

public class Rectangle extends AbstractFigure {
	final double length;
	final double width;

	Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	@Override
	double area() {
		return length * width;
	}
}
```

