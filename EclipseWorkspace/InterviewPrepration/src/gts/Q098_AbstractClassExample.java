package gts;

/**
 * Difference between abstract class and interface write in java code
 * */
/**
 * 
 * 	Abstract Class:
	  	Can have both abstract methods (without implementation) and concrete methods (with implementation).
		Can have instance variables.
		Can have constructors.	
		Methods can have various access modifiers (private, protected, public).	
		A class can inherit from only one abstract class (single inheritance).	
		Suitable for providing shared code among related classes.	
		Can maintain state using instance variables.	
		Can provide default method implementations.	
		Can be used to provide a common base and shared functionality for subclasses.	
		Cannot implement multiple abstract classes.	
		Allows subclassing to inherit both behaviour and state (instance variables).
 * */
abstract class Animals {
	// Concrete method (can have a body)
	public void eat() {
		System.out.println("This animal eats food.");
	}

	// Abstract method (must be implemented by subclass)
	public abstract void sound();
}

// Concrete class that extends the abstract class
class Dogs extends Animals {
	// Implementing the abstract method
	public void sound() {
		System.out.println("Bark");
	}
}

public class Q098_AbstractClassExample {
	public static void main(String[] args) {
		Dogs dog = new Dogs();
		dog.eat(); // Concrete method from the abstract class
		dog.sound(); // Implemented in the Dog class
	}
}
/**
 * 
 	Advantages of Abstract Class Over Interface:
		Can have instance variables and constructors, allowing for the creation of shared state.
		Can provide default method implementations, making it easier to provide common behaviour for subclasses.
		Can use different access modifiers for methods (private, protected, public), giving more flexibility in controlling method visibility.
		Can be used to share code among related classes.
		Suited for class hierarchies where multiple classes share common functionality but also need to define their own specific behaviour.
		
   Disadvantages of Abstract Class Over Interface:
		A class can only extend one abstract class due to Java’s single inheritance model.
		Does not allow for multiple inheritance of behaviours.
		Adding a new method to an abstract class breaks the existing implementation in subclasses (unless it's a default method).
 * */
/**
 * Use Case for Abstract Class:
		When multiple classes share common code and need to inherit behaviour and state.
		When you need to define a base class that provides default implementations for some methods and leaves others abstract for subclass customization.
		When you want to establish a relationship between classes in a hierarchy where subclasses are closely related (e.g., Animal, Dog, Cat).
		When the behaviour is common across subclasses but subclasses need to implement some specific behaviour (e.g., base class for payment systems like PaymentMethod, and subclasses for CreditCardPayment, PaypalPayment).
 * */
