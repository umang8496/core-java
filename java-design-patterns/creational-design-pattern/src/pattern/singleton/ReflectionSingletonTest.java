package pattern.singleton;

import java.lang.reflect.Constructor;

// Reflection can be used to destroy all the singleton implementation approaches.
public class ReflectionSingletonTest {
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
        EarlyInitializedSingleton instanceOne = EarlyInitializedSingleton.getInstance();
        EarlyInitializedSingleton instanceTwo = null;
        try {
            Constructor[] constructors = EarlyInitializedSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (EarlyInitializedSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }

}


// When you run the above test class, hashCode of both the instances is not same that destroys the singleton pattern.
