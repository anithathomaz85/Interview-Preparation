package geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

public class Q3_LargestSubarrayWith0Sum {

	public static void main(String[] args) {
		int[] arr = { 15, -2, 2, -8, 1, 7, 10, 23 };
		System.out.println("Length of the longest subarray with sum 0 is " + maxLen(arr)); // Output: 5
	}

	static int maxLen(int arr[]) {
		Map<Integer, Integer> sumIndexMap = new HashMap<>();
		int maxLen = 0;
		int currSum = 0;

		for (int i = 0; i < arr.length; i++) {
			currSum += arr[i];
			if (currSum == 0) {
				maxLen = i + 1;
			}
			if (sumIndexMap.containsKey(currSum)) {
				int prevIndex = sumIndexMap.get(currSum);
				maxLen = Math.max(maxLen, i - prevIndex);
			} else {
				sumIndexMap.put(currSum, i);
			}
		}
		return maxLen;
	}

}
