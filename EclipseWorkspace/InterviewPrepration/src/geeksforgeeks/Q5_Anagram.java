package geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

public class Q5_Anagram {

	public static void main(String[] args) {
		String s1 = "silent";
		String s2 = "listen";

		boolean result = areAnangrams(s1, s2);
		System.out.println(result);

	}

	private static boolean areAnangrams(String s1, String s2) {

		Map<Character, Integer> countMap = new HashMap<>();

		for (char c : s1.toCharArray()) {
			countMap.put(c, countMap.getOrDefault(c, 0) + 1);
		}

		for (char c : s2.toCharArray()) {
			if (!countMap.containsKey(c))return false;
			countMap.put(c, countMap.get(c) - 1);
			if (countMap.get(c) < 0)return false;
		}
		return true;
	}

}
