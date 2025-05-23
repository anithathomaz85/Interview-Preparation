package gts;

import java.util.HashSet;
import java.util.Set;

/**
 * Print all permutation of a string.
   Input: String s = ""ABC""
   Output: ABC ACB BAC BCA CAB CBA"

 * */
public class Q037_PermutationOfAString {
	public static Set<String> permutation(String str) {
		 
		// create a set to avoid duplicate permutation
		Set<String> permutations = new HashSet<String>();
 
		// check if string is null
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			// terminating condition for recursion
			permutations.add("");
			return permutations;
		}
 
		// get the first character
		char first = str.charAt(0);
 
		// get the remaining substring
		String sub = str.substring(1);
 
		// make recursive call to getPermutation()
		Set<String> words = permutation(sub);
 
		// access each element from words
		for (String strNew : words) {
			for (int i = 0; i <= strNew.length(); i++) {
 
				// insert the permutation to the set
				permutations.add(strNew.substring(0, i) + first + strNew.substring(i));
			}
		}
		return permutations;
	}
 
	public static void main(String[] args) {
 
		// create an object of scanner class
		// Scanner input = new Scanner(System.in);
 
		// take input from users
		// System.out.print("Enter the string: ");
		// String data = input.nextLine();
		String data = "ABC";
		System.out.println("Permutations of " + data + ": \n" + permutation(data));
	}
}
