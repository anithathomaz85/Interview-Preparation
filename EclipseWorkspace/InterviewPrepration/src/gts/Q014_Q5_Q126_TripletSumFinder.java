package gts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an input array 
   int [] arr = {9,2,7,1,6,4,3,5};
   sum is =7
   sum=2,1,4 with three index combination to get the sum.
   
   Time complexity O(n2)
   Space complexity O(n)
 * */
public class Q014_Q5_Q126_TripletSumFinder {
	
	public static void main(String[] args) {
		int[] arr = {9,2,7,1,6,4,3,5};
        int targetSum = 7;
		getTriplets(arr,targetSum);
	}

	private static List<List<Integer>> getTriplets(int[] arr,int targetSum) {
		
        
        Arrays.sort(arr); 
        int n = arr.length;
        
        Set<List<Integer>> result =  new HashSet<>();
        
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == targetSum) {
                    System.out.println("Triplet: " + arr[i] + ", " + arr[left] + ", " + arr[right]);
                    result.add(Arrays.asList(arr[i],arr[left],arr[right]));
                    left++;
                    right--; 
                } else if (sum < targetSum) {
                    left++;  // Increase the sum by moving left
                } else {
                    right--; // Decrease the sum by moving right
                }
            }
        }
        return new ArrayList<>(result);
	}
}
