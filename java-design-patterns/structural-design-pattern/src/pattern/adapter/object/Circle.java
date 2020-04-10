package pattern.adapter.object;

public class Circle implements Shape {

	private double radius;
	// private final double PI = 3.14;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public void draw() {
		System.out.println("Circle is Drawn.");
	}

	@Override
	public String description() {
		return "Circle: [ radius: " + this.radius + " ]";
	}

}
