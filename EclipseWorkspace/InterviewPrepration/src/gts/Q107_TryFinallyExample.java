package gts;

/**
 * write catch block without try and viceversa
 */

public class Q107_TryFinallyExample {

	public static void main(String[] args) {
		System.out.println("Program started.");

		try {
			System.out.println("Inside try block.");

			// Simulate risky operation
			int result = 10 / 0;

			System.out.println("This will not print.");
		} finally {
			System.out.println("Inside finally block. Cleanup here.");
		}

		System.out.println("Program continues..."); // this won't be reached due to unhandled exception
	}

}

/*
 *
 * 1. Catch Block Without Try You cannot write a catch block without a try block
 * in Java. A catch block must always be preceded by a try block because it is
 * meant to handle exceptions thrown within the try block.
 * 
 * A catch block by itself will result in a compilation error.
 * 
 * 2. Try Block Without Catch A try block can exist without a catch block if you
 * pair it with a finally block or use a throws clause in a method signature.
 **********************************************
 * 
 * public void someMethod() throws Exception { try { // some code that might
 * throw an exception } finally { // cleanup code, always executed } }
 ***********************************************
 * A try block can also exist with a catch block omitted if you are using a
 * throws declaration in the method signature to propagate the exception.
 * 
 * Key Points: A catch block cannot exist alone; it must be paired with a try.
 * 
 * A try block can exist alone if followed by a finally block or if exceptions
 * are declared with throws.
 */