package pattern.singleton;

public class EarlyInitializedSingleton {
	private static final EarlyInitializedSingleton instance = new EarlyInitializedSingleton();
	
	private EarlyInitializedSingleton() {
		super();
	}
	
	public static EarlyInitializedSingleton getInstance() {
		return instance;
	}
}

/*
 * In eager initialization, the instance of Singleton Class is created at the time of class loading,
 * this is the easiest method to create a singleton class but it has a drawback that
 * instance is created even though client application might not be using it.
 * 
 * */
