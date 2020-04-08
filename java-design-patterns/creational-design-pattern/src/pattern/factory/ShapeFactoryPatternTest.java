package pattern.factory;

public class ShapeFactoryPatternTest {

	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		
		// get Rectangle object and draw it
		Shape shape1 = shapeFactory.getShape("RECTANGLE");
		shape1.draw();
		
		// get Square object and draw it
		Shape shape2 = shapeFactory.getShape("SQUARE");
		shape2.draw();
		
		Shape shape3 = shapeFactory.getShape("CIRCLE");
		shape3.draw();
	}

}
