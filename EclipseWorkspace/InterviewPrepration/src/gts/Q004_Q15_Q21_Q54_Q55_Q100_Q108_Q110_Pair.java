package gts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Program to find sub-arrays from a given array which have the given sum Input
 * : arr = {2,4,1,3,5,1} sum=6 Output : subarrays = {2,4},{5,1}"
 */
public class Q004_Q15_Q21_Q54_Q55_Q100_Q108_Q110_Pair {

	public static void main(String[] args) {
		
	    int[] nums = {2, 4, 1, 3, 5, 1};
	    int targetSum = 6;
	    
	    
	    List<String> pairs = findUnorderedPairsWithSum(nums, targetSum);
	    if (pairs.isEmpty()) {
	        System.out.println("No pairs found.");
	    } else {
	        System.out.println("Pairs found with sum : "+ targetSum + ": " + pairs);
	    }
	    
	    
		List<List<Integer>> subarrays = findContinuousSubarraysWithSum(nums, targetSum);
		if (subarrays.isEmpty()) {
	        System.out.println("No subarray found.");
	    } else {
	    	System.out.println("Subarrays with sum " + targetSum + ": " + subarrays);
	    }	    

	}

	private static List<String> findUnorderedPairsWithSum(int[] nums, int targetSum) {
	    List<String> pairs = new ArrayList<>();
	    Map<Integer, Integer> map = new HashMap<>();

	    for (int i = 0; i < nums.length; i++) {
	        int complement = targetSum - nums[i];

	        if (map.containsKey(complement)) {
	            pairs.add("(" + complement + ", " + nums[i] + ")");
	        }

	        map.put(nums[i], i);
	    }

	    return pairs;
	}


	private static List<List<Integer>> findContinuousSubarraysWithSum(int[] arr, int targetSum) {
	    List<List<Integer>> result = new ArrayList<>();

	    for (int i = 0; i < arr.length; i++) {
	        int sum = 0;
	        List<Integer> subarray = new ArrayList<>();

	        for (int j = i; j < arr.length; j++) {
	            sum += arr[j];
	            subarray.add(arr[j]);
	            //System.out.println("Subarray:"+subarray.toString());

	            if (sum == targetSum) {
	                result.add(new ArrayList<>(subarray));
	                //System.err.println("result:"+result.toString());
	                //System.out.println();
	            }
	        }
	        //System.out.println();
	    }
	    return result;
	}
}
