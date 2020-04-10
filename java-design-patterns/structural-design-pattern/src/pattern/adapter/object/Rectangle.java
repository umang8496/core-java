package pattern.adapter.object;

public class Rectangle implements Shape {

	private double length;
	private double breadth;

	public Rectangle(double length, double breadth) {
		super();
		this.length = length;
		this.breadth = breadth;
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
	public void draw() {
		System.out.println("Rectangle is Drawn.");
	}

	@Override
	public String description() {
		return "Rectangle: [ length: " + this.length + " breadth: " + this.breadth + " ]";
	}

}
