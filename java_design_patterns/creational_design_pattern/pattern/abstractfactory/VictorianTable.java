package pattern.abstractfactory;

public class VictorianTable implements Table {

	public VictorianTable() {
		super();
	}
	
	@Override
	public void tableProperties() {
		System.out.println("It os a Victorian Table.");		
	}
	
}
