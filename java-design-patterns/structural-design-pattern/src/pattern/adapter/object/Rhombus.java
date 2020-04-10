package pattern.adapter.object;

public class Rhombus implements Quadrilateral {

	public Rhombus() {
		super();
	}
	
	@Override
	public String description() {
		return "Quadrilateral: Rhombus";
	}

	@Override
	public void drawShape() {
		System.out.println("Rhombus is drawn.");
	}

}
