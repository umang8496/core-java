package pattern.builder;

public class Director {

	public Director() {
		super();
	}
	
	private VehicleBuilder builder;
	
	public void setBuilder(VehicleBuilder builder) {
		this.builder = builder;
	}
	
	public void constructCar() {
		this.builder.reset();
		this.builder.setEngine(300f);
		this.builder.setSeats(5);
		this.builder.setWheels(4);
		this.builder.setGPS(true);
	}
	
	public void constructSUV() {}
	
	public void constructBus() {}
}
