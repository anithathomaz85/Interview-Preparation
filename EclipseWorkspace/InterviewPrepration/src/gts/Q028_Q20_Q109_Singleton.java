package gts;

/**
 * What is singleton design pattern , write the code for singleton in eclipse
 * */
public class Q028_Q20_Q109_Singleton {

	private static Q028_Q20_Q109_Singleton mySingletonInstance = null;

	private Q028_Q20_Q109_Singleton() {
		System.out.println("From Singleton private constructor");
	}

// Synchronized is to ensure only one thread to access this method at a single point of time.
	public synchronized static Q028_Q20_Q109_Singleton getInstance() {

		if (mySingletonInstance == null) {
			mySingletonInstance = new Q028_Q20_Q109_Singleton();
		}
		return mySingletonInstance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {

		System.out.println("inside clone method");
		return new CloneNotSupportedException("Cloning of singleton class not allowed.");
	}

	public static void main(String[] args) throws CloneNotSupportedException {

		System.out.println("Main method " + Thread.currentThread().getName());
		Q028_Q20_Q109_Singleton singleton = Q028_Q20_Q109_Singleton.getInstance();
		System.out.println(singleton);

		Q028_Q20_Q109_Singleton singleton2 = Q028_Q20_Q109_Singleton.getInstance();
		System.out.println(singleton2);

		singleton.clone();

		System.out.println("Main method" + Thread.currentThread().getName());

	}

}
