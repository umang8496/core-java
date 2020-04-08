package pattern.abstractfactory;

public class AbstractFactoryPatternTest {
	public static void main(String[] args) {
		//get rounded shape factory
		AbstractFactory shapeFactory = FactoryProducer.getFactory(false);
		
		//get an object of Shape Rounded Rectangle
		Shape shape1 = shapeFactory.getShape("RECTANGLE");
		
		//call draw method of Shape Rectangle
		shape1.draw();
		
		//get an object of Shape Rounded Square 
		Shape shape2 = shapeFactory.getShape("SQUARE");
		
		//call draw method of Shape Square
		shape2.draw();
		
		//get rounded shape factory
		AbstractFactory shapeFactoryRounded = FactoryProducer.getFactory(true);
		
		//get an object of Shape Rectangle
		Shape shape3 = shapeFactoryRounded.getShape("RECTANGLE");
		
		//call draw method of Shape Rectangle
		shape3.draw();
		
		//get an object of Shape Square 
		Shape shape4 = shapeFactoryRounded.getShape("SQUARE");
		
		//call draw method of Shape Square
		shape4.draw();
	}
}
