package gts;

/**
 * Reverse alphanumeric and special character string ("ajsggs^%@$#@71552")
 * without using any built in method (valueOf(), chartAt(), toCharArray())
 */
public class Q093_ReverseString {

	public static void main(String[] args) {
		String input = "ajsggs^%@$#@71552";
		System.out.println("Original string: " + input);

		byte[] bytes = input.getBytes(); //This converts the String into a byte array.Each character in the string is converted into its byte representation.

		System.out.print("Reversed string: ");
		for (int i = bytes.length - 1; i >= 0; i--) {
			System.out.print((char) bytes[i]);
		}			
	}
}
