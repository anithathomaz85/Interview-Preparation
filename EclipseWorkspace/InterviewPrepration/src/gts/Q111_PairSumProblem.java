package gts;

/*
* Qn111 Problem Statement: Given an array of integers arr[] and an integer target.
1st variant: Return YES if there exist two numbers such that their sum is equal to the target. Otherwise, return NO.
2nd variant: Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}.
Note: You are not allowed to use the same element twice. Example: If the target is equal to 6 and num[1] = 3, then nums[1] + nums[1] = target is not a solution.
Examples:
Example 1:
Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 14
Result: YES (for 1st variant)
       [1, 3] (for 2nd variant)
Explanation: arr[1] + arr[3] = 14. So, the answer is “YES” for the first variant and [1, 3] for 2nd variant.
 
Example 2:
Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 15
Result: NO (for 1st variant)
	[-1, -1] (for 2nd variant)
Explanation: There exist no such two numbers whose sum is equal to the target.
write a code for above problem?."
 
*/
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q111_PairSumProblem {

	// 1st Variant: Check if pair exists
	public static String isPairExists(int[] arr, int target) {
		Set<Integer> seen = new HashSet<>();

		for (int num : arr) {
			int complement = target - num;
			if (seen.contains(complement)) {
				return "YES";
			}
			seen.add(num);
		}

		return "NO";
	}

	// 2nd Variant: Return indices of the pair
	public static int[] getTwoSumIndices(int[] arr, int target) {
		Map<Integer, Integer> map = new HashMap<>(); // number -> index

		for (int i = 0; i < arr.length; i++) {
			int complement = target - arr[i];

			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i }; // map to array
			}

			map.put(arr[i], i);
		}

		return new int[] { -1, -1 }; // not found
	}

	public static void main(String[] args) {
		int[] arr = { 2, 6, 5, 8, 11 };
		int target = 14;

		// First Variant
		System.out.println("First Variant (YES/NO): " + isPairExists(arr, target));

		// Second Variant
		int[] result = getTwoSumIndices(arr, target);
		System.out.print("Second Variant (Indices): [" + result[0] + ", " + result[1] + "]");
	}
}
