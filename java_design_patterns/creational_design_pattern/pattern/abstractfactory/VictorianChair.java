package pattern.abstractfactory;

public class VictorianChair implements Chair {

	public VictorianChair() {
		super();
	}
	
	@Override
	public void chairProperties() {
		System.out.println("It os a Victorian Chair.");		
	}

}
