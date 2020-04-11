package pattern.facade;

import java.util.logging.Logger;

public class FacadeDemo {
	private static final Logger LOGGER = Logger.getLogger(FacadeDemo.class.getName());

	public static void main(String[] args) {
		CarEngineFacade carEngine = new CarEngineFacade();
		LOGGER.info("Starting car engine");
		carEngine.startEngine();
		System.out.println();
		LOGGER.info("Stopping car engine");
		carEngine.stopEngine();
	}
}
