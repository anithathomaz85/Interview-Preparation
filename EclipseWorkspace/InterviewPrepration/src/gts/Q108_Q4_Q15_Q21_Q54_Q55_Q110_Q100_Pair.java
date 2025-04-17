package gts;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * find two nos in an ArrayList that's sum is to a target sum.
 */

public class Q108_Q4_Q15_Q21_Q54_Q55_Q110_Q100_Pair {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(5, 2, 3, 1, 7);
		int target = 7;

		findTwoNumbersWithSum(numbers, target);
	}

	public static void findTwoNumbersWithSum(List<Integer> nums, int target) {
		Set<Integer> seenNumbers = new HashSet<>();

		for (Integer num : nums) {
			int complement = target - num;

			if (seenNumbers.contains(complement)) {
				System.out.println("Pair found: " + num + " and " + complement);
				return;
			}
			seenNumbers.add(num);
		}
		System.out.println("No pair found with the given sum.");
	}
}
