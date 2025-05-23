package gts;

/**
 *  Reverse the given array
 * */
public class Q097_ReverseArray {
	
	public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
 
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
 
            start++;
            end--;
        }
    }
	
	 public static void main(String[] args) {
	        int[] arr = {10, 20, 30, 40, 50};
	        System.out.print("Original array: ");
	        for (int num : arr) {
	            System.out.print(num + " ");
	        }
	        
	        reverseArray(arr);
	        
	        System.out.print("\nReversed array: ");
	        for (int num : arr) {
	            System.out.print(num + " ");
	        }
	    }
	}