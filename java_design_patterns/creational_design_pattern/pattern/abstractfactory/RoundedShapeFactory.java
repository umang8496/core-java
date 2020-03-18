package pattern.abstractfactory;

public class RoundedShapeFactory extends AbstractFactory {
	
	@Override
	public Shape getShape(String shapeType) {
		if(shapeType == null) {
			return null;
		}
		
		if(shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new RoundedRectangle();
		} else {
			return new RoundedSquare();
		}
		
	}

}
