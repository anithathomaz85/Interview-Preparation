package gts;

import java.util.HashMap;
import java.util.Map;

/**
 *  check if two strings are anagram using data structure  * 
 *  
 *  */
public class Q019_AnagramChecker {
	 public static void main(String[] args) {
	        String str1 = "listen";
	        String str2 = "silent";

	        System.out.println("Anagrams? " + isAnagram(str1, str2));
	    }
	 
	 public static boolean isAnagram(String s1, String s2) {
	        if (s1.length() != s2.length()) return false;

	        Map<Character, Integer> charCount = new HashMap<>();

	        for (char ch : s1.toCharArray()) {
	            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
	        }

	        for (char ch : s2.toCharArray()) {
	            if (!charCount.containsKey(ch)) return false;

	            charCount.put(ch, charCount.get(ch) - 1);
	            if (charCount.get(ch) < 0) return false;
	        }
	        return true;
	    }
}
