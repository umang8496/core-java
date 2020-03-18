package pattern.abstractfactory;

public class ModernChair implements Chair {

	public ModernChair() {
		super();
	}
	
	@Override
	public void chairProperties() {
		System.out.println("It os a Modern Chair.");		
	}
	
}
