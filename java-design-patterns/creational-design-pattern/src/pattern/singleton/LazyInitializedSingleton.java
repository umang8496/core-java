package pattern.singleton;

public class LazyInitializedSingleton {
	private static LazyInitializedSingleton instance = null;
	
	private LazyInitializedSingleton() {
		super();
	}
	
	public static LazyInitializedSingleton getInstance() {
		if(instance == null) {
			instance = new LazyInitializedSingleton();
		}
		return instance;
	}
}

/*
 * This implementation works fine in case of the single-threaded environment but when it comes to multithreaded systems,
 * it can cause issues if multiple threads are inside the if condition at the same time.
 * It will destroy the singleton pattern and both threads will get the different instances of the singleton class.
 * 
 * */
