package pattern.adapter.object;

public class Parallelogram implements Quadrilateral {

	public Parallelogram() {
		super();
	}
	
	@Override
	public String description() {
		return "Quadrilateral: Parallelogram";
	}

	@Override
	public void drawShape() {
		System.out.println("Parallelogram is drawn.");
	}

}
