package pattern.adapter.object;

public class QuadrilateralAdapter implements Shape {

	private Quadrilateral quadrilateral;
	
	public QuadrilateralAdapter(Quadrilateral quadrilateral) {
		super();
		this.quadrilateral = quadrilateral;
	}
	
	@Override
	public void draw() {
		quadrilateral.drawShape();
	}

	@Override
	public String description() {
		return quadrilateral.description();
	}

}
