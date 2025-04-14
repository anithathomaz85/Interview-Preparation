package gts;

/**
 * {1,1,1,2,2,2,4,4,5,5,8,8,9,9}  find index of right most of 5, 
 * here 9 the re time and space complexity, way to improve the efficiency of the program
 * */
public class Q078_RightmostIndexFinder {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 2, 2, 2, 4, 4, 5, 5, 8, 8, 9, 9 };
		  //int[] arr = { 1, 2, 2, 5, 5, 5 };
		int target = 5;

		int rightLinear = findRightmostLinear(arr, target);
		int rightBinary = findRightmostBinary(arr, target);

		System.out.println("Rightmost index of " + target + " (Linear Search): " + rightLinear);
		System.out.println("Rightmost index of " + target + " (Binary Search): " + rightBinary);
	}

// Linear Search: O(n) time, O(1) space
	public static int findRightmostLinear(int[] arr, int target) {
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				index = i; // keep updating until last match
			}
		}
		return index;
	}

// Binary Search: O(log n) time, O(1) space
	public static int findRightmostBinary(int[] arr, int target) {
		int low = 0, high = arr.length - 1, result = -1;
		while (low <= high) {
			int mid = low + (high-low)/2;
			if (arr[mid] == target) {
				result = mid;
				low = mid + 1;
			} else if (arr[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return result;
	}
}