package gts;

/*
* 113. write a sample program for Singleton Design pattern?
 
*/
public class Q113_Singleton {
 
	public static void main(String[] args) {
 
		// 1.Eager Singleton
 
		EagerSingleton s1 = EagerSingleton.getInstance();
 
		EagerSingleton s2 = EagerSingleton.getInstance();
 
		// 2.Lazy Singleton
		/*
		 * LazySingleton s1 = LazySingleton.getInstance();
		 * 
		 * 
		 * LazySingleton s2 = LazySingleton.getInstance();
		 * 
		 */
 
		// 3.Threadsafe (Synchronised)
		/*
		 * ThreadSafeSingleton s1 = ThreadSafeSingleton.getInstance();
		 * 
		 * ThreadSafeSingleton s2 = ThreadSafeSingleton.getInstance();
		 */
 
		// 4.Doublecheckedlocking
 
		/*
		 * DoubleCheckedLockingSingleton s1 =
		 * DoubleCheckedLockingSingleton.getInstance();
		 * 
		 * DoubleCheckedLockingSingleton s2 =
		 * DoubleCheckedLockingSingleton.getInstance();
		 */
 
		s1.show();
 
		// Check if both instances are same
		if (s1 == s2) {
			System.out.println("Both objects are the same instance.");
		} else {
			System.out.println("Different instances.");
		}
	}
 
}
 
class EagerSingleton {
	// Instance is created when class is loaded
	private static final EagerSingleton instance = new EagerSingleton();
 
	private EagerSingleton() {
		System.out.println("Eager Singleton Instance Created");
	}
 
	public static EagerSingleton getInstance() {
		return instance;
	}
 
	public void show() {
		System.out.println("Eager Singleton show() method");
	}
}
 
class LazySingleton {
	private static LazySingleton instance;
 
	private LazySingleton() {
		System.out.println("Lazy Singleton Instance Created");
	}
 
	public static LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
 
	public void show() {
		System.out.println("Lazy Singleton show() method");
	}
}
 
class ThreadSafeSingleton {
	private static ThreadSafeSingleton instance;
 
	private ThreadSafeSingleton() {
		System.out.println("Thread-safe Singleton Instance Created");
	}
 
	public static synchronized ThreadSafeSingleton getInstance() {
		if (instance == null) {
			instance = new ThreadSafeSingleton();
		}
		return instance;
	}
 
	public void show() {
		System.out.println("Thread-Safe Singleton show() method");
	}
}
 
class DoubleCheckedLockingSingleton {
	private static volatile DoubleCheckedLockingSingleton instance;
 
	private DoubleCheckedLockingSingleton() {
		System.out.println("Double-Checked Singleton Instance Created");
	}
 
	public static DoubleCheckedLockingSingleton getInstance() {
		if (instance == null) {
			synchronized (DoubleCheckedLockingSingleton.class) {
				if (instance == null) {
					instance = new DoubleCheckedLockingSingleton();
				}
			}
		}
		return instance;
	}
 
	public void show() {
		System.out.println("Double-Checked Singleton show() method");
	}
}