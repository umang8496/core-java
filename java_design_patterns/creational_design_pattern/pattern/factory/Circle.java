package pattern.factory;

public class Circle implements Shape {
	private double radius;
	private static final double PI = 3.14;
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return this.radius;
	}

	@Override
	public double getArea() {
		return (PI * this.radius * this.radius);
	}

	@Override
	public void draw() {
		System.out.println("It's a Circle.");
	}

	@Override
	public double getPerimeter() {
		return (2 * PI * this.radius);
	}
	
	
}
