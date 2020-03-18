package pattern.builder;

public interface VehicleBuilder {
	public void reset();
	public void setSeats(int numberOfSeats);
	public void setEngine(float enginePower);
	public void setWheels(int numberOfWheels);
	public void setGPS(boolean putGPS);
}
