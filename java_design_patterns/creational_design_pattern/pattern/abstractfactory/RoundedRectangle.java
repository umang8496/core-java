package pattern.abstractfactory;

public class RoundedRectangle implements Shape {
	
	public RoundedRectangle() {
		super();
	}
	
	@Override
	public void draw() {
		System.out.println("It's a RoundedRectangle.");
	}

	@Override
	public double getArea() {
		return 0;
	}

	@Override
	public double getPerimeter() {
		return 0;
	}
}
