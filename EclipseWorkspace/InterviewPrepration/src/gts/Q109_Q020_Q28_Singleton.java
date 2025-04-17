package gts;

/**
 * Singleton design pattern with code
 */
class Singleton implements Cloneable {

	private static Singleton mySingletonInstance = null;

	// Private constructor to restrict instantiation from other classes
	private Singleton() {
		System.out.println("From Singleton private constructor");
	}

	// Thread-safe method to get single instance
	public synchronized static Singleton getInstance() {

		if (mySingletonInstance == null) {
			mySingletonInstance = new Singleton();
		}
		return mySingletonInstance;
	}

	// Prevent cloning
	@Override
	protected Object clone() throws CloneNotSupportedException {

		System.out.println("inside clone method");
		throw new CloneNotSupportedException("Cloning of singleton class not allowed.");
	}
}

public class Q109_Q020_Q28_Singleton {
	public static void main(String[] args) {
		System.out.println("Main method: " + Thread.currentThread().getName());

		Singleton singleton1 = Singleton.getInstance();
		System.out.println("Instance 1: " + singleton1);

		Singleton singleton2 = Singleton.getInstance();
		System.out.println("Instance 2: " + singleton2);

		// Try cloning
		try {
			singleton1.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Main method end: " + Thread.currentThread().getName());
	}
}
