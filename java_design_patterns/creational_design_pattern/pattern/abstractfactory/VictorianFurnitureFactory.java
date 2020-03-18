package pattern.abstractfactory;

public class VictorianFurnitureFactory implements AbstractFurnitureFactory {

	@Override
	public Chair createChair() {
		return new VictorianChair();
	}

	@Override
	public Sofa createSofa() {
		return new VictorianSofa();
	}

	@Override
	public Table createTable() {
		return new VictorianTable();
	}

}
