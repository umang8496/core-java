package pattern.factory;

public class Rectangle implements Shape {
	private double length;
	private double breadth;
	
	public Rectangle() {
		super();
	}
	
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getBreadth() {
		return breadth;
	}

	public void setBreadth(double breadth) {
		this.breadth = breadth;
	}
	
	@Override
	public double getArea() {
		return (this.length * this.breadth);
	}

	@Override
	public void draw() {
		System.out.println("It's a Rectangle.");
	}

	@Override
	public double getPerimeter() {
		return 2 * (this.length + this.breadth);
	}
}
