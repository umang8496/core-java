package pattern.facade;

import java.util.logging.Logger;

public class TemperatureSensor {
	private static final Logger LOGGER = Logger.getLogger(TemperatureSensor.class.getName());

	public void getTemperature() {
		LOGGER.info("Getting temperature from the sensor..");
	}
}
