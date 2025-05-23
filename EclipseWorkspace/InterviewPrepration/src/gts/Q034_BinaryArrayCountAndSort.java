package gts;

import java.util.Arrays;

public class Q034_BinaryArrayCountAndSort {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 0, 1, 0, 1, 0, 0, 0 };
		 
		count0s1s(arr);
 
		int[] sortedArr = sortBinaryArray(arr);
		System.out.println("Sorted array"+Arrays.toString(sortedArr));		
		
	}


	private static void count0s1s(int[] arr) {
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
	}


	public static int[] sortBinaryArray(int[] arr) {
		 
		int zeroCount = 0;
	
		for (int num : arr) {
			if (num == 0)
				zeroCount++;
		}
	
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