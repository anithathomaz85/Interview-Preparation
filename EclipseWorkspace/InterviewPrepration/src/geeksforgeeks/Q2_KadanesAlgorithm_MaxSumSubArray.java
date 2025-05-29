package geeksforgeeks;

/**
 * Kadane's Algorithm
 * 
 *  Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
	Output: 11
	Explanation: The subarray {7, -1, 2, 3} has the largest sum 11.
	
	Input: arr[] = [-2, -4]
	Output: -2
	Explanation: The subarray {-2} has the largest sum -2.
	
	Input: arr[] = [5, 4, 1, 7, 8]
	Output: 25
	Explanation: The subarray {5, 4, 1, 7, 8} has the largest sum 25.
	
 * */
public class Q2_KadanesAlgorithm_MaxSumSubArray {
	
	public static void main(String[] args) {
		
		int[] arr = {2, 3, -8, 7, -1, 2, 3};
		int maxSum = maxSubarraySum(arr);
		System.out.println("Max sum of SubArray: "+maxSum);
	}

	private static int maxSubarraySum(int[] arr) {
		
		int currSum = arr[0];
		int maxSum = arr[0];
		
		for(int i=1;i<arr.length;i++) {
			currSum = Math.max(arr[i], currSum+arr[i]);
			maxSum = Math.max(maxSum, currSum);
		}
		
		return maxSum;	
		
	}

}
