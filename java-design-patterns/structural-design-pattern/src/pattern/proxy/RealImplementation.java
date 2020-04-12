package pattern.proxy;

public class RealImplementation implements Internet {

	@Override
	public void connectToSite(String serverhost) throws Exception {
		System.out.println("Connecting to " + serverhost);
	}

}
