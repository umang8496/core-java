package pattern.abstractfactory;

public class ShapeFactory extends AbstractFactory {
	
	@Override
	public Shape getShape(String shapeType) {
		if(shapeType == null) {
			return null;
		}
		
		if(shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();
		} else {
			return new Square();
		}
		
	}
}
