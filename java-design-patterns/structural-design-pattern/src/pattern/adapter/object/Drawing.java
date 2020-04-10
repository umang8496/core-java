package pattern.adapter.object;

import java.util.ArrayList;
import java.util.List;

public class Drawing {
	List<Shape> shapes = new ArrayList<Shape>();

	public Drawing() {
		super();
	}

	public void addShape(Shape shape) {
		shapes.add(shape);
	}

	public List<Shape> getShapes() {
		return new ArrayList<Shape>(shapes);
	}

	public void draw() {
		if (shapes.isEmpty()) {
			System.out.println("Nothing to draw!");
		} else {
			shapes.stream().forEach(shape -> shape.draw());
		}
	}

	public void describe() {
		if (shapes.isEmpty()) {
			System.out.println("No Description!");
		} else {
			shapes.stream().forEach(shape -> System.out.println(shape.description()));
			//for (Shape shape: shapes) {
			//	System.out.println(shape.description());
			//}
		}
	}
}
