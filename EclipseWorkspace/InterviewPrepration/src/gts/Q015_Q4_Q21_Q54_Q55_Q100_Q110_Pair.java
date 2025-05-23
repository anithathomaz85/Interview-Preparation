package gts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a program to add two numbers from given list to get sum of 9 ex: 3+6=9; 8+1=9
 * 
 * https://leetcode.com/problems/two-sum/
 * */
public class Q015_Q4_Q21_Q54_Q55_Q100_Q110_Pair {
	public static void main(String[] args) {
		int[] nums = {2, 4, 1, 3, 5, 1, 6, 8};
		int targetSum = 9;
		 
		List<int[]> pairs = getPairs(nums, targetSum);
		for(int[]pair:pairs) {
			System.out.println(Arrays.toString(pair));
		}
		
		attempt1(nums,targetSum);
	}

	private static List<int[]> getPairs(int[] nums, int targetSum) {
		
		List<int[]> result=  new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
	        
			int complement = targetSum - nums[i];

	        if (map.containsKey(complement)) {
	        	result.add(new int[] { complement, nums[i] });        			
	        }	        
	        map.put(nums[i], i);
	    }
		return result;
	}	
	
	private static void attempt1(int[] nums, int targetSum) {
		boolean found = false;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
	        
			int complement = targetSum - nums[i];

	        if (map.containsKey(complement)) {
	        	System.out.println("Pair found: (" + complement + ", " + nums[i] + ")");
	        	found = true;
	        }
	        
	        map.put(nums[i], i);
	    }

		 if (!found) {
	            System.out.println("No pairs found.");
	        }
	}
}
