package gts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find triplets from the given array equals to the given sum? What is the time complexity?
 * */
public class Q126_Q5_Q14_Triplets {

	public static void main(String[] args) {
		int[] arr = { -2, 1, 2, 4, 5 };
		int targetSum = 3;
		getTriplets(arr, targetSum);
	}

	private static List<List<Integer>> getTriplets(int[] arr, int targetSum) {

		Arrays.sort(arr);
		int n = arr.length;

		Set<List<Integer>> result = new HashSet<>();

		for (int i = 0; i < n - 2; i++) {
			int left = i + 1, right = n - 1;

			while (left < right) {
				int sum = arr[i] + arr[left] + arr[right];

				if (sum == targetSum) {
					System.out.println("Triplet: " + arr[i] + ", " + arr[left] + ", " + arr[right]);
					result.add(Arrays.asList(arr[i], arr[left], arr[right]));
					left++;
					right--;
				} else if (sum < targetSum) {
					left++; // Increase the sum by moving left
				} else {
					right--; // Decrease the sum by moving right
				}
			}
		}
		return new ArrayList<>(result);
	}
}
