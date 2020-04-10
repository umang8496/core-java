package pattern.decorator;

public class IcecreamDecoratorDemo {
	
	public static void main(String args[]) {
		Icecream icecream_first = new SimpleIcecream();
		Icecream icecream_second = new NuttyDecorator(new SimpleIcecream());
		Icecream icecream_third = new HoneyDecorator(new NuttyDecorator(new SimpleIcecream()));
		
		System.out.println("icecream_first: " + icecream_first.makeIcecream());
		System.out.println("icecream_second: " + icecream_second.makeIcecream());
		System.out.println("icecream_third: " + icecream_third.makeIcecream());
	}
	
}
