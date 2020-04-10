package pattern.adapter.object;

public class ObjectAdapterMain {
	public static void main(String[] args) {
		System.out.println("Creating shapes!");

		Drawing drawing = new Drawing();
		drawing.addShape(new Rectangle(10,10));
		drawing.addShape(new Circle(10));
		drawing.addShape(new QuadrilateralAdapter(new Parallelogram()));
		drawing.addShape(new QuadrilateralAdapter(new Rhombus()));

		System.out.println("Drawing Shapes!");
		drawing.draw();
		System.out.println("Describing Shapes!");
		drawing.describe();
	}
}
