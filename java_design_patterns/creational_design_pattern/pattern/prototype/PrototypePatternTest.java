package pattern.prototype;

public class PrototypePatternTest {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(10,8);
		System.out.println("For r1 : " + r1.getArea());
		System.out.println("For r1 : " + r1.getPerimeter());
		
		Rectangle r2 = new Rectangle(r1);
		System.out.println("For r2 : " + r2.getArea());
		System.out.println("For r2 : " + r2.getPerimeter());
		
		System.out.println("r1 : " + r1);	// r1 : pattern.prototype.Rectangle@15db9742
		System.out.println("r2 : " + r2);	// r2 : pattern.prototype.Rectangle@6d06d69c
	}
}
