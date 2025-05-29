package geeksforgeeks;

/**
Given a sorted and rotated array arr[] of distinct elements, the task is to find the index of a target key. Return -1 if the key is not found.

Examples :

Input: arr[] = [5, 6, 7, 8, 9, 10, 1, 2, 3], key = 3
Output: 8
Explanation: 3 is found at index 8.*/
public class Q8_RotatedArraySearch {

	public static void main(String[] args) {
		int[] arr = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		int key = 3;
		int index = search(arr, key);
		System.out.println("Index of " + key + ": " + index); // Output: 8

	}

	public static int search(int[] arr, int key) {
		int low = 0, high = arr.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr[mid] == key) {
				return mid;
			}

			// Check if left half is sorted
			if (arr[low] <= arr[mid]) { // true:left half from low to mid is sorted.
				if (arr[low] <= key && key < arr[mid]) { // check if the key lies within this sorted half:
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			// Right half is sorted
			else {
				if (arr[mid] < key && key <= arr[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}

		return -1; // Key not found
	}
}
