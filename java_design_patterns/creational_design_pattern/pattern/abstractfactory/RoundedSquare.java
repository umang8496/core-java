package pattern.abstractfactory;

public class RoundedSquare implements Shape {

	public RoundedSquare() {
		super();
	}
	
	@Override
	public void draw() {
		System.out.println("It's a RoundedSquare.");
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
