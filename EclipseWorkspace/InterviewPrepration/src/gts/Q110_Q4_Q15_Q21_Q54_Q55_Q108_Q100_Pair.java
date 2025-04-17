package gts;

import java.util.HashSet;
import java.util.Set;

/**
 *  Two Sum : Check if a pair with given sum exists in Array
	52317
 * */
public class Q110_Q4_Q15_Q21_Q54_Q55_Q108_Q100_Pair {

	public static void main(String[] args) {
		int[] array = { 5, 2, 3, 1, 7 };
		int target = 7;

		boolean result = hasPairWithSum(array, target);
		if (!result) {
			System.out.println("No pair found with sum " + target);
		}
	}

	private static boolean hasPairWithSum(int[] nums, int target) {
		Set<Integer> seen = new HashSet<>();
		for (int num : nums) {
			int complement = target - num;
			if (seen.contains(complement)) {
				System.out.println("Pair Found: (" + num + ", " + complement + ")");
				return true;
			}
			seen.add(num);
		}
		return false;
	}

}
