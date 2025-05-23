package gts;

import java.util.HashSet;

/***
 * 87. What is longest none repeating substring in string str = "abcdefgabc" eg
 * > abcdefg = 7
 */
public class Q087_LongestSubString {
	public static void printLongestUniqueSubstring(String str) {
		HashSet<Character> set = new HashSet<>();
		int left = 0, maxLen = 0, start = 0;

		for (int right = 0; right < str.length(); right++) {
			while (set.contains(str.charAt(right))) {
				set.remove(str.charAt(left));
				left++;
			}

			set.add(str.charAt(right));

			if (right - left + 1 > maxLen) {
				maxLen = right - left + 1;
				start = left;
			}
		}

		String longest = str.substring(start, start + maxLen);
		System.out.println("Longest unique substring: " + longest);
		System.out.println("Length: " + maxLen);
	}

	public static void main(String[] args) {

		String input = "abcdefgabc";
		printLongestUniqueSubstring(input);
	}
}
