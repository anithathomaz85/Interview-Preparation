package gts;

/**
 * Given an sorted array. find the given number. int nums[] = {1, 2, 3, 4, 5, 6}
 */
/**
 * Time Complexity:O(log n)
		Each iteration of the binary search halves the search space, so the time complexity is logarithmic in the size of the array.

	Space Complexity:O(1)
		Binary Search uses a constant amount of space for variables like left, right, and mid.
 * */
public class Q099_BinarySearch {
	public static void main(String[] args) {
		
		int[] nums = { 1, 2, 3, 4, 5, 6 };
		int target = 4;

		int result = binarySearch(nums, target);

		if (result == -1) {
			System.out.println("Number not found.");
		} else {
			System.out.println("Number found at index: " + result);
		}
	}

	// Binary Search function
	public static int binarySearch(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == target) {
				return mid; 
			}

			if (nums[mid] < target) {
				left = mid + 1;
			}			
			else {
				right = mid - 1;
			}
		}		
		return -1;
	}
}