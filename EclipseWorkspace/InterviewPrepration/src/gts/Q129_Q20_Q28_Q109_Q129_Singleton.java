package gts;

/**
 *  Design patterns Singleton and factory -> asked to write a pseudo code 
 * */
public class Q129_Q20_Q28_Q109_Q129_Singleton {

	private static Q129_Q20_Q28_Q109_Q129_Singleton mySingletonInstance = null;

	private Q129_Q20_Q28_Q109_Q129_Singleton() {
		System.out.println("From Singleton private constructor");
	}

// Synchronized is to ensure only one thread to access this method at a single point of time.
	public synchronized static Q129_Q20_Q28_Q109_Q129_Singleton getInstance() {

		if (mySingletonInstance == null) {
			mySingletonInstance = new Q129_Q20_Q28_Q109_Q129_Singleton();
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
		Q129_Q20_Q28_Q109_Q129_Singleton singleton = Q129_Q20_Q28_Q109_Q129_Singleton.getInstance();
		System.out.println(singleton);

		Q129_Q20_Q28_Q109_Q129_Singleton singleton2 = Q129_Q20_Q28_Q109_Q129_Singleton.getInstance();
		System.out.println(singleton2);

		singleton.clone();

		System.out.println("Main method" + Thread.currentThread().getName());

	}

}
