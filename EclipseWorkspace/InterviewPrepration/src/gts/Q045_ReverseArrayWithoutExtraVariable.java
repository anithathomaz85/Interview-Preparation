package gts;

/**
 * Write a program to reverse a integer array using the same variable
 * Without using an additional array.

 * */
public class Q045_ReverseArrayWithoutExtraVariable {

	public static void reverseArray(int[] arr) {
		int start = 0;
		int end = arr.length -1;
		
		while(start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end]   = temp;
			
			start++;
			end--;
		}
	}
	
	public static void printArray(int [] arr) {
		for(int num : arr) {
			System.out.print(num + "  ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		
		System.out.println("Original Array");
		printArray(arr);
		
		reverseArray(arr);
		
		System.out.println("Reversed Array");
		printArray(arr);
		
	}
}