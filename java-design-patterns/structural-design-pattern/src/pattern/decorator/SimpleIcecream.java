package pattern.decorator;

public class SimpleIcecream implements Icecream {

	public SimpleIcecream() {
		super();
	}

	@Override
	public String makeIcecream() {
		return "Base Icecream";
	}
}
