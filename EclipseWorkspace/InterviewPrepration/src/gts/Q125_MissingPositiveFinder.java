package gts;

import java.util.HashSet;
import java.util.Set;

public class Q125_MissingPositiveFinder {
	public static int findMissingPositiveNumber(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
				int temp = nums[i];
				nums[i] = nums[temp - 1];
				nums[temp - 1] = temp;
			}
		}
		for (int i = 0; i < n; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return n + 1;
	}

	public static int findMissingPositiveUsingSet(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (num > 0) {
				set.add(num);
			}
		}
		for (int i = 1; i <= nums.length + 1; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2 };
		int[] arr2 = { 3, 4, -1, 1 };
		int[] arr3 = { 7, 11, 9, 12, 8 };
		System.out.println(findMissingPositiveNumber(arr1));
		System.out.println(findMissingPositiveNumber(arr2));
		System.out.println(findMissingPositiveNumber(arr3));
		
		System.out.println("************Using Set***********");
		System.out.println(findMissingPositiveUsingSet(arr1));
		System.out.println(findMissingPositiveUsingSet(arr2));
		System.out.println(findMissingPositiveUsingSet(arr3));
	}
}