package pattern.proxy;

public class ProxyDemo {
	public static void main(String[] args) {
		Internet internet = new ProxyImplementation();
		try {
			internet.connectToSite("https://github.com/");
			internet.connectToSite("https://www.amazon.in/");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
