package pattern.builder;

public class BuilderPatternTest {

	public static void makeCar() {
		Director director = new Director();
		CarBuilder builder = new CarBuilder();
		
		director.setBuilder(builder);
		director.constructCar();
		Car car = builder.getProduct();
		
		car.displayFuelVariant();
		car.displayVehicleConfiguration();
		car.displayVehiclePrice();
	}
	
	public static void makeSUV() {}
	
	public static void makeBus() {}
	
	public static void main(String[] args) {
		makeCar();
		// makeSUV();
		// makeBus();
	}
	
}
