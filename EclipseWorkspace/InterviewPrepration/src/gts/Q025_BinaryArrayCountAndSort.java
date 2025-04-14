package gts;

/*
* Array Sort Problem ? 1, 1, 0, 1, 0, 1, 0, 0, 0
Elements in Array - Binary array 
Dynamically find number of 0 and 1
Sub Questions 
•	Approach explain first 
Arrays.sort shouldn’t be used 
Space & time complexity in your solution
*/
public class Q025_BinaryArrayCountAndSort {

	public static void main(String[] args) {
		 
		int[] arr = { 1, 1, 0, 1, 0, 1, 0, 0, 0 };
 
		int zeroCount = 0;
		int oneCount = 0;
 
		for (int num : arr) {
			if (num == 0) {
				zeroCount++;
			} else if (num == 1) {
				oneCount++;
			}
		}
 
		System.out.println("Number of 0s: " + zeroCount);
		System.out.println("Number of 1s: " + oneCount);
 
		int[] sortedArr = sortBinaryArray(arr);
		System.out.println("Sorted array");
		for (int num : sortedArr) {
			System.out.print(" " + num);
		}
	}
 
	public static int[] sortBinaryArray(int[] arr) {
 
		int zeroCount = 0;
 
		for (int num : arr) {
			if (num == 0)
				zeroCount++;
		}
 
		// Fill the array: first 0s, then 1s
 
		for (int i = 0; i < arr.length; i++) {
 
			if (i < zeroCount) {
 
				arr[i] = 0;
			} else {
				arr[i] = 1;
			}
		}
		return arr;
	}
 
}