package gts;

import java.util.Arrays;

//https://leetcode.com/problems/move-zeroes/
/**
 * Array with a positive integer and 0.
 * Push all zero at the end and non-zero to the beginning 
   example -> int[] arr = {2,0,8,5,0,3} & output -> {2,8,5,3,0,0}
 * */
/**
 * 
**/
public class Q001_MoveZerosToEnd {
	public static void main(String[] args) {

		int[] arr = { 2, 0, 8, 5, 0, 3 };
		int[] result = new int[arr.length];

		result = moveZerosToEnd(arr);
		System.out.println(Arrays.toString(result));

		moveZerosToEndInPlace(arr);
		System.out.println(Arrays.toString(arr));

	}

	/**
	 * Time Complexity - O(n) The algorithm traverses the array → O(n) 
	 * Space Complexity - O(n) created a new array result of size n
	 */
	public static int[] moveZerosToEnd(int[] arr) {
		int[] result = new int[arr.length];
		int j = 0;

		for (int i = 0; i <= arr.length - 1; i++) {
			if (arr[i] > 0) {
				result[j] = arr[i];
				j++;
			}
		}
		return result;
	}

	/**
	 * Function to move zeros to the end (in-place) 
	 * Time Complexity - O(n) The algorithm traverses the array → O(n) 
	 * Space Complexity - O(1) In place
	 * approach
	 */
	public static void moveZerosToEndInPlace(int[] arr) {
		int index = 0;

		for (int num : arr) {
			if (num != 0) {
				arr[index++] = num;
			}
		}

		while (index < arr.length) {
			arr[index++] = 0;
		}
	}
}
