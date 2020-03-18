package pattern.singleton;

import java.io.Serializable;

public class SerializedSingleton implements Serializable {
	private static final long serialVersionUID = -7604766932017737115L;
	
	private SerializedSingleton() {}
	
	private static class SingletonHelper {
		private static final SerializedSingleton INSTANCE = new SerializedSingleton();
	}
	
	public static SerializedSingleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
}


/*
 * Sometimes in distributed systems, we need to implement Serializable interface in Singleton class
 * so that we can store its state in the file system and retrieve it at a later point of time.
 * 
 * The problem with serialized singleton class is that whenever we deserialize it, it will create a new instance of the class.
 * 
 * */
