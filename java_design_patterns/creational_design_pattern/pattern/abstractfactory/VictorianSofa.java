package pattern.abstractfactory;

public class VictorianSofa implements Sofa {

	public VictorianSofa() {
		super();
	}
	
	@Override
	public void sofaProperties() {
		System.out.println("It os a Victorian Sofa.");		
	}
	
}
