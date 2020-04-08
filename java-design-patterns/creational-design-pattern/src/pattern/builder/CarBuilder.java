package pattern.builder;

public class CarBuilder implements VehicleBuilder {

	private Car car;
	private int numberOfSeats;
	private int numberOfWheels;
	private boolean putGPS;
	private float enginePower;
	
	@Override
	public void reset() {
		this.car = new Car();
	}

	@Override
	public void setSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
		System.out.println("adding seats");
	}

	@Override
	public void setEngine(float enginePower) {
		this.enginePower = enginePower;
		System.out.println("adding engines");
	}

	@Override
	public void setWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
		if(numberOfWheels < 4) {
			
		}
		System.out.println("adding wheels");
	}

	@Override
	public void setGPS(boolean putGPS) {
		this.putGPS = putGPS;
		if(putGPS == false) {
			System.out.println("No GPS");
		} else {
			System.out.println("GPS Enabled");
		}
	}
	
	public Car getProduct() {
		this.reset();
		return car;
	}
	
	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public int getNumberOfWheels() {
		return numberOfWheels;
	}

	public void setNumberOfWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}

	public boolean isPutGPS() {
		return putGPS;
	}

	public void setPutGPS(boolean putGPS) {
		this.putGPS = putGPS;
	}

	public float getEnginePower() {
		return enginePower;
	}

	public void setEnginePower(float enginePower) {
		this.enginePower = enginePower;
	}

}
