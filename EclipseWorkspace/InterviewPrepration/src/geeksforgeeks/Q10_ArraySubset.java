package geeksforgeeks;

import java.util.HashMap;

public class Q10_ArraySubset {
	public static boolean isSubset(int[] a, int[] b) {
		
		HashMap<Integer, Integer> freqMap = new HashMap<>();

		// Count frequency of each element in array a
		for (int num : a) {
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}

		// Check each element in b against the map
		for (int num : b) {
			if (!freqMap.containsKey(num) || freqMap.get(num) == 0) {
				return false; // not present or used up
			}
			freqMap.put(num, freqMap.get(num) - 1); // use one occurrence
		}

		return true;
	}

	public static void main(String[] args) {
        int[] a = {11, 7, 1, 13, 21, 3, 7, 3};
        int[] b = {11, 3, 7, 1, 7};

        System.out.println(isSubset(a, b)); // Output: true
    }
}
