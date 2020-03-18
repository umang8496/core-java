package pattern.prototype;

public abstract class TwoDShape {

	private String shapeType;
	
	public TwoDShape() {
		super();
	}
	
	public TwoDShape(TwoDShape source) {
		this();
		this.shapeType = source.shapeType;
	}
	
	public abstract float getArea();
	public abstract float getPerimeter();
	public abstract Object clone();
	
	public String getShapeType() {
		return shapeType;
	}

	public void setShapeType(String shapeType) {
		this.shapeType = shapeType;
	}

}
