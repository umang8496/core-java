package pattern.abstractfactory;

public class ModernFurnitureFactory implements AbstractFurnitureFactory {

	@Override
	public Chair createChair() {
		return new ModernChair();
	}

	@Override
	public Sofa createSofa() {
		return new ModernSofa();
	}

	@Override
	public Table createTable() {
		return new ModernTable();
	}
	
}
