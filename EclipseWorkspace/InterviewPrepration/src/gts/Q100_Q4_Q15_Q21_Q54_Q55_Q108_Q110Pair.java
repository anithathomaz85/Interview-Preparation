package gts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a sorted array. Find the pair for given sum. 
 * int nums[] = {1, 2, 3, 4, 5, 6}
 */
/**
 * Time Complexity:
 		O(n) - Since the array is sorted	
 * */
public class Q100_Q4_Q15_Q21_Q54_Q55_Q108_Q110Pair {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6 };
		int target = 9;

		List<String> twoPointerPairs = findAllPairsUsingTwoPointer(nums, target);
		List<String> complementPairs = findAllPairsUsingComplement(nums, target);
		List<String> complementUniquePairs = findAllUniquePairsUsingComplement(nums, target);
		List<String> binarySearchPairs = findAllPairsUsingBinarySearch(nums, target);
		
		List<String> binarySearchDuplicatePairs = findAllPairsUsingBinarySearchWithDuplicates(nums, target);

		System.out.println("Using Two-pointer approach:");
		if (twoPointerPairs.isEmpty()) {
			System.out.println("No pairs found for sum " + target);
		} else {
			twoPointerPairs.forEach(System.out::println);
		}
		System.out.println();

		System.out.println("Using HashSet complement approach:");
		if (complementPairs.isEmpty()) {
			System.out.println("No pairs found for sum " + target);
		} else {
			complementPairs.forEach(System.out::println);
		}
		System.out.println();
		
		System.out.println("Using HashSet unique complement approach:");
		if (complementUniquePairs.isEmpty()) {
			System.out.println("No pairs found for sum " + target);
		} else {
			complementUniquePairs.forEach(System.out::println);
		}
		System.out.println();

		System.out.println("Using Binary Search approach:");
		if (binarySearchPairs.isEmpty()) {
			System.out.println("No pairs found for sum " + target);
		} else {
			binarySearchPairs.forEach(System.out::println);
		}
		System.out.println();
		
		System.out.println("Using Binary Search with Duplicates approach:");
		if (binarySearchDuplicatePairs.isEmpty()) {
			System.out.println("No pairs found for sum " + target);
		} else {
			binarySearchPairs.forEach(System.out::println);
		}

	}

	/**
	 * Two-pointer approach Best for sorted arrays — fastest and least space 
	 * Time Complexity: O(n) 
	 * 			→ Since each pointer moves at most n steps, total number of operations = n.
	 */
	private static List<String> findAllPairsUsingTwoPointer(int[] nums, int target) {
		List<String> pairs = new ArrayList<>();
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int sum = nums[left] + nums[right];

			if (sum == target) {
				pairs.add("(" + nums[left] + ", " + nums[right] + ")");
				left++;
				right--;
			} else if (sum < target) {
				left++;
			} else {
				right--;
			}
		}
		return pairs;
	}

	/**
	 * HashSet complement approach Best for unsorted arrays — no need to sort Time
	 * Complexity: O(n) → One pass through the array + constant time contains and
	 * add operations on a HashSet. Space Complexity: O(n) → In the worst case, all
	 * elements might be added to the seen set.
	 */
	private static List<String> findAllPairsUsingComplement(int[] nums, int target) {
		List<String> pairs = new ArrayList<>();
		Set<Integer> seen = new HashSet<>();

		for (int num : nums) {
			int complement = target - num;

			if (seen.contains(complement)) {
				pairs.add("(" + num + ", " + complement + ")");
			}

			seen.add(num);
		}
		return pairs;
	}
	
	
	private static List<String> findAllUniquePairsUsingComplement(int[] nums, int target) {
	    List<String> pairs = new ArrayList<>();
	    Set<Integer> seen = new HashSet<>();
	    Set<String> addedPairs = new HashSet<>();

	    for (int num : nums) {
	        int complement = target - num;

	        if (seen.contains(complement)) {
	            // Form a sorted string key to avoid (4,2) vs (2,4)
	            int min = Math.min(num, complement);
	            int max = Math.max(num, complement);
	            String pairStr = "(" + min + ", " + max + ")";

	            if (!addedPairs.contains(pairStr)) {
	                pairs.add(pairStr);
	                addedPairs.add(pairStr);
	            }
	        }
	        seen.add(num);
	    }
	    return pairs;
	}

	/**
	 * Binary Search Good for sorted arrays if you specifically want to practice
	 * binary search 
			 * Time Complexity: Outer loop: O(n) 
			 * Inner binary search: O(log n)
			 * Total: O(n log n)
	 */

	public static List<String> findAllPairsUsingBinarySearch(int[] nums, int target) {
		List<String> pairs = new ArrayList<>();
		
		Arrays.sort(nums); // Important: binary search works on sorted arrays

		for (int i = 0; i < nums.length - 1; i++) {
			int low = i + 1; //Avoid comparing with itself
			int high = nums.length - 1;

			while (low <= high) {
				int mid = low + (high - low) / 2;
				int sum = nums[i] + nums[mid];

				if (sum == target) {
					pairs.add("(" + nums[i] + ", " + nums[mid] + ")");
					break; // move to next i after finding a pair
				} else if (sum < target) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return pairs;
	}
	
	public static List<String> findAllPairsUsingBinarySearchWithDuplicates(int[] nums, int target) {
	    List<String> pairs = new ArrayList<>();

	    Arrays.sort(nums); // Important: binary search works on sorted arrays

	    for (int i = 0; i < nums.length - 1; i++) {
	        int low = i + 1;
	        int high = nums.length - 1;

	        while (low <= high) {
	            int mid = low + (high - low) / 2;
	            int sum = nums[i] + nums[mid];

	            if (sum == target) {
	                pairs.add("(" + nums[i] + ", " + nums[mid] + ")");

	                // Since array is sorted, check both sides for possible duplicates
	                int left = mid - 1;
	                while (left > i && nums[i] + nums[left] == target) {
	                    pairs.add("(" + nums[i] + ", " + nums[left] + ")");
	                    left--;
	                }

	                int right = mid + 1;
	                while (right < nums.length && nums[i] + nums[right] == target) {
	                    pairs.add("(" + nums[i] + ", " + nums[right] + ")");
	                    right++;
	                }

	                // After collecting all possible pairs, break
	                break;
	            } else if (sum < target) {
	                low = mid + 1;
	            } else {
	                high = mid - 1;
	            }
	        }
	    }
	    return pairs;
	}

}
