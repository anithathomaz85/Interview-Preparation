package gts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * **Description:** Given an array of integers, return the indices of the two numbers such that they add up to a specific target.
**Sample Test Cases:**
- Input: nums = [2, 7, 11, 15], target = 9 → Output: [0, 1]
- Input: nums = [3, 2, 4], target = 6 → Output: [1, 2]
 * */
public class Q021_PairsIndices {

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int targetSum = 9;
		List<int[]> pairs = getPairs(nums, targetSum);
		for(int[]pair:pairs) {
			System.out.println(Arrays.toString(pair));
		}

	}

	private static List<int[]> getPairs(int[] nums, int targetSum) {
		
		List<int[]> result=  new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++) {
			int complement = targetSum-nums[i];
			if(map.containsKey(complement))
				result.add(new int[] {map.get(complement),i});
			map.put(nums[i], i);
		}		
		return result;
	}

}
