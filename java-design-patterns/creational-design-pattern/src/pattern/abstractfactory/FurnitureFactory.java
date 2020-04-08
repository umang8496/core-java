package pattern.abstractfactory;

public class FurnitureFactory {

	public static AbstractFurnitureFactory getFurniture(String variant) {
		if(variant == null) {
			return null;
		}
		
		if(variant.equalsIgnoreCase("VICTORIAN")) {
			return new VictorianFurnitureFactory();
		} else { // variant.equalsIgnoreCase("MODERN")
			return new ModernFurnitureFactory();
		}
	}
}
