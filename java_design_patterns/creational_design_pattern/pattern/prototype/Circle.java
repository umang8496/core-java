package pattern.prototype;

public class Circle extends TwoDShape {

	private String shapeType;
	private float radius;
	private static final float PI = 3.14f;
	
	public Circle() {
		super();
	}

	public Circle(float radius) {
		this.radius = radius;
		this.shapeType = "CIRCLE";
	}
	
	public Circle(Circle source) {
		super(source);
		this.radius = source.radius;
		this.shapeType = "CIRCLE";
	}
	
	@Override
	public float getArea() {
		return PI * this.radius * this.radius;
	}

	@Override
	public float getPerimeter() {
		return 2 * PI * this.radius;
	}

	@Override
	public Object clone() {
		return new Circle(this);
	}
	
	public String getShapeType() {
		return shapeType;
	}

	public void setShapeType(String shapeType) {
		this.shapeType = shapeType;
	}
	
}
