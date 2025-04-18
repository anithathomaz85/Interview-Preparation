package gts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q131_isSubsequence {

	static boolean isSubsequence(String str1, String str2) {

		// Initialize pointers for both strings
		int i = 0;
		int j = 0;
		// We can iterate until either of them becomes zero...

		while (i < str1.length() && j < str2.length()) {
			// Compare characters, increment both pointers if same
			if (str1.charAt(i) == str2.charAt(j)) {
				i++;
				j++;
			} else {
				j++; // Only increment second pointer
			}
		}

		// If it is a subsequence, 'i' will have travelled full
		// length of string 'str1', so just check and return
		return (i == str1.length());
	}
	
	public static void main(String[] args) throws IOException {


		String str1 = "";
		String str2 = "";
		
		str1 = "one";
		str2 = "longest";
		
		/*str1 = "cde";
		str2 = "abcde";*/
		
		/*str1 = "abc";
		str2 = "ahbgdc";*/
		
		/*str1 = "axc";
		str2 = "ahbgdc";*/
		
		boolean isSubseq = isSubsequence(str1, str2);
		System.out.println("Is Subsequence: " + isSubseq);
	}

}