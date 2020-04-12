package pattern.proxy;

import java.util.ArrayList;
import java.util.List;

public class ProxyImplementation implements Internet {

	private Internet internet = new RealImplementation();
	private static List<String> bannedSites;

	static {
		bannedSites = new ArrayList<String>();
		bannedSites.add("https://www.google.co.in/");
		bannedSites.add("https://www.amazon.in/");
		bannedSites.add("https://www.logicbig.com/");
	}

	@Override
	public void connectToSite(String serverhost) throws Exception {
		if (bannedSites.contains(serverhost.toLowerCase())) {
			throw new Exception("Access Denied");
		}
		internet.connectToSite(serverhost);
	}

}
