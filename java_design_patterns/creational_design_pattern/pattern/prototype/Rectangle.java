package pattern.prototype;

public class Rectangle extends TwoDShape {

	private String shapeType;
	private float length;
	private float breadth;
	
	public Rectangle() {
		super();
	}

	public Rectangle(float length, float breadth) {
		this.length = length;
		this.breadth = breadth;
		this.shapeType = "RECTANGLE";
	}
	
	public Rectangle(Rectangle source) {
		super(source);
		this.length = source.length;
		this.breadth = source.breadth;
		this.shapeType = "RECTANGLE";
	}
	
	@Override
	public float getArea() {
		return this.length * this.breadth;
	}

	@Override
	public float getPerimeter() {
		return this.length + this.breadth;
	}

	@Override
	public Object clone() {
		return new Rectangle(this);
	}
	
	public String getShapeType() {
		return shapeType;
	}

	public void setShapeType(String shapeType) {
		this.shapeType = shapeType;
	}

}
