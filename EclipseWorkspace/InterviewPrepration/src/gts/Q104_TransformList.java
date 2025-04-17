package gts;

import java.util.Arrays;

/*
* 104. Input: nums = [1,1,0,3,3]
Output: [0,0,9,0,0]
*/
public class Q104_TransformList {

	public static int[] transformList(int[] nums) {

		int[] output = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				output[i] = 9;
			} else {
				output[i] = 0;
			}
		}
		return output;

	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 0, 3, 3 };
		int[] output = transformList(nums);
		System.out.println(Arrays.toString(output));
	}
}
