package pattern.abstractfactory;

public class FurnitureAbstractFactoryTest {

	public static void main(String[] args) {
		AbstractFurnitureFactory furniture_victorian = FurnitureFactory.getFurniture("VICTORIAN");
		AbstractFurnitureFactory furniture_modern = FurnitureFactory.getFurniture("MODERN");
		
		furniture_victorian.createChair().chairProperties();
		furniture_victorian.createSofa().sofaProperties();
		furniture_victorian.createTable().tableProperties();
		
		furniture_modern.createChair().chairProperties();
		furniture_modern.createSofa().sofaProperties();
		furniture_modern.createTable().tableProperties();
	}
	
}
