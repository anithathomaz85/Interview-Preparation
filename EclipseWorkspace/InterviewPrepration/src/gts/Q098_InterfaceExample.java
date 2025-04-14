package gts;

/**
 * Difference between abstract class and interface write in java code
 * */
/**
 * 
 * 	Interface:
		Can only have abstract methods (unless default or static methods are used from Java 8 onwards).		
		Cannot have instance variables (fields are public static final constants).		
		Cannot have constructors.
		Methods are implicitly public and abstract (unless default or static methods).		
		A class can implement multiple interfaces (multiple inheritance).		
		Defines a contract that can be implemented by any class, regardless of the class hierarchy.		
		Cannot maintain state (no instance variables).		
		Interfaces cannot provide state but can provide default methods from Java 8 onwards.		
		Used to define a set of behaviours that different classes can implement.		
		A class can implement multiple interfaces, allowing it to inherit multiple behaviours.		
		Provides a way to achieve loose coupling between classes by defining behaviour independently from implementation.
 * */
interface Animal {
	// Abstract method (implicitly public and abstract)
	void sound();

	default void eat() {
		System.out.println("This animal eats food.");
	}
	static void test() {
		System.out.println("Testing static method");
	}
}

// Concrete class that implements the interface
class Dog implements Animal {
	// Implementing the abstract method
	public void sound() {
		System.out.println("Bark");
	}
}

public class Q098_InterfaceExample {

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.eat(); // Default method from the interface
		dog.sound(); // Implemented in the Dog class
		Animal.test();
	}

}

/**
 * Advantages of Interface Over Abstract Class:
		A class can implement multiple interfaces, allowing for multiple inheritance of behavior.
		Interfaces are ideal for defining a contract that can be implemented by unrelated classes.
		Interfaces promote loose coupling, making it easier to replace implementations without affecting the overall system.
		Can provide multiple behavior types (via default methods in Java 8 and later).
		Allows for more flexibility in class design, especially in cases where a class needs to adhere to multiple contracts.

	Disadvantages of Interface Over Abstract Class:
		Cannot have instance variables or constructors.
		Methods in interfaces (except default/static) are always abstract and cannot have a body (before Java 8), making them less flexible.
		Cannot maintain state.
		All methods are implicitly public, which may not always be desirable.
		Cannot provide method implementations before Java 8 (except default or static methods from Java 8 onwards).
 * */
/***
 * Use Case for Interface:
		When you want to define a contract that various unrelated classes must follow, regardless of their class hierarchy.
		When you need multiple classes to share common behaviour but do not need to define shared state or implementation (e.g., Runnable, Serializable).
		When you need to allow for multiple inheritance of behaviours across different classes (e.g., a class that implements both Movable and Readable interfaces).
		For cases where a class can adopt multiple behaviours, like with interfaces in the strategy pattern (e.g., PaymentMethod, ShippingMethod).
		Ideal for defining APIs and callback mechanisms (e.g., Observer pattern, event listeners).
 * */
/***
 * A static method in an interface:
		belongs to the interface itself, not to instances of implementing classes
		can be called without implementing the interface or creating an object
		is useful for utility, helper, or factory methods related to the interface’s purpose
		public interface PaymentProcessor {
    		void processPayment(double amount);

    		static boolean isValidAmount(double amount) {
        	return amount > 0;
    		}	
		}//Interfaces with static methods aren’t meant to replace utility classes.
		Static methods in interfaces cannot be overridden by implementing classes.
		
		
		interface Calculator {
    			static int add(int a, int b) {
        		return a + b;
    			}
		}

		public class Test {
    	public static void main(String[] args) {
        	int result = Calculator.add(5, 3);
        	System.out.println(result);  // 8
    		}
		}	

 * 
 * */
