package pattern.abstractfactory;

public class ModernTable implements Table {

	public ModernTable() {
		super();
	}
	
	@Override
	public void tableProperties() {
		System.out.println("It os a Modern Table.");		
	}
	
}
