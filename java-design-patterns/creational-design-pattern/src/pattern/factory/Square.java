package pattern.factory;

public class Square implements Shape {
	private double side;

	public Square() {
		super();
	}
	
	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	@Override
	public double getArea() {
		return (this.side * this.side);
	}

	@Override
	public void draw() {
		System.out.println("It's a Square.");
	}

	@Override
	public double getPerimeter() {
		return 4 * this.side;
	}
}
