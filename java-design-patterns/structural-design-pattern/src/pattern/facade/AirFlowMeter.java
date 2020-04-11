package pattern.facade;

import java.util.logging.Logger;

public class AirFlowMeter {
	private static final Logger LOGGER = Logger.getLogger(AirFlowMeter.class.getName());

	public void getMeasurements() {
		LOGGER.info("Getting air measurements..");
	}
}
