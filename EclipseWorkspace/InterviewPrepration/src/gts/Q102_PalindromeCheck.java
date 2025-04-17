package gts;

/*
* 102. String name = "nitin". check if it is a palindrome.
 
*/
public class Q102_PalindromeCheck {

	public static void main(String[] args) {
		String name = "nitin";

		// Approach 1: Without using built-in reverse methods
		boolean isPalindromeManual = isPalindromeManual(name);

		if (isPalindromeManual) {
			System.out.println("Approach 1: \"" + name + "\" is a palindrome.");
		} else {
			System.out.println("Approach 1: \"" + name + "\" is not a palindrome.");
		}

		// Approach 2: Using StringBuilder reverse
		boolean isPalindromeBuiltIn = isPalindromeBuiltIn(name);

		if (isPalindromeBuiltIn) {
			System.out.println("Approach 2: \"" + name + "\" is a palindrome.");
		} else {
			System.out.println("Approach 2: \"" + name + "\" is not a palindrome.");
		}
	}

	// Approach 1: Manual comparison without using reverse functions
	public static boolean isPalindromeManual(String str) {

		int len = str.length();

		for (int i = 0; i < len / 2; i++) {

			if (str.charAt(i) != str.charAt(len - 1 - i)) {

				return false;
			}
		}
		return true;
	}

	// Approach 2: Using StringBuilder reverse
	public static boolean isPalindromeBuiltIn(String str) {
		String reversed = new StringBuilder(str).reverse().toString();
		return str.equals(reversed);
	}
}
