package gts;

/**
 * class Util
	{
	public static int add(int a, int b)
	{
	return a+b;
	}
	}
	
	Questions: 
	1. is this method is thread safe or not?
	2. logic to convert the code into non thread safe?"

 * 
 * */
public class Q065_ThreadSafe {

	class Util {
		public static int add(int a, int b) {
			return a + b;
		}
	}

}

/*
Yes, this method is thread-safe.
Reason:
 
It’s a pure function — no shared state, no modification of any class-level or static variables.
 
Each call to add() operates only on the inputs a and b, and returns a new result.
 
There are no side effects or shared mutable data, so multiple threads calling this method
simultaneously won't interfere with each other.

_________________________________________________________________________________________________

To make it non-thread-safe, you need to introduce a shared mutable state (like a static variable)
that is modified inside the method.
 
class Util {
private static int result = 0;
 
public static int add(int a, int b) {
    result = a + b;
    return result;
}
}
 

Why is this non-thread-safe?
The result variable is shared among all threads (it’s static).
 
If two threads call add() at the same time, they could overwrite result and produce inconsistent
or incorrect results.
 
*/
