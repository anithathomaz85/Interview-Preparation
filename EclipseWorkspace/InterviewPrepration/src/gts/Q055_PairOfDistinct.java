package gts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***
 * modifications : find all pairs of distinct elements in an array 
 * whose sum equals 0, using the input {1, 2, 3, 5, -5}.
 * */
public class Q055_PairOfDistinct {
	public static List<List<Integer>> findZeroSumPairs(int[] arr) {
		Set<Integer> seen = new HashSet<>(); 
		Set<String> uniquePairs = new HashSet<>();
		List<List<Integer>> result = new ArrayList<>(); 

		for (int num : arr) {
			int opposite = -num;

			if (seen.contains(opposite)) {
				int a = Math.min(num, opposite);
				int b = Math.max(num, opposite);
				String key = a + " : " + b;

				if (uniquePairs.add(key)) {
					result.add(Arrays.asList(a, b));
				}
			}
			seen.add(num);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 5, -5 };
		List<List<Integer>> pairs = findZeroSumPairs(input);

		System.out.println("Pairs with sum zero:");
		for (List<Integer> pair : pairs) {
			System.out.println(pair);
		}
	}

}