package gts;

/**
 * A peak element is an element that is strictly greater than its neighbors.
 * Given a 0-indexed integer array nums, find a peak element, and return its
 * index. If the array contains multiple peaks, return the index to any of the
 * peaks.added question in the same scenario for the given input 
 * 		{1, 3, -1, -3, 5, 3, 6, 7} 
 * consider 3 nos and find the highest (peak) like for 
 * 		1, 3, -1 peakval is 3 
 * 		3, -1, -3 peakval is 3 
 * 		-1, -3, 5 peakval is 5 
 * 		-3, 5, 3 peakval is 5 
 *	 	5, 3, 6 peakval is 6 
 * 		3, 6, 7 peakval is 7
 * 
 */
public class Q088_findPeakElement {

	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		findPeakElementWithIndex(nums);
		System.out.println("\n");
		findPeakElement(nums);

	}
	
	private static void findPeakElement(int[] nums) {
	    for (int i = 0; i <= nums.length - 3; i++) {
	        int first = nums[i];
	        int second = nums[i + 1];
	        int third = nums[i + 2];

	        int maxVal = Math.max(first, Math.max(second, third));

	        System.out.println("(" + first + ", " + second + ", " + third + ") -> Peak value: " + maxVal);
	    }
	}

	private static void findPeakElementWithIndex(int[] nums) { 
		
		for (int i = 0; i <= nums.length - 3; i++) {

			int maxVal = nums[i];
			int maxIndex = i;

			if (nums[i + 1] > maxVal) {
				maxVal = nums[i + 1];
				maxIndex = i + 1;
			}

			if (nums[i + 2] > maxVal) {
				maxVal = nums[i + 2];
				maxIndex = i + 2;
			}

        System.out.println("(" + nums[i] + ", " + nums[i+1] + ", " + nums[i+2] + ") -> Peak at index: " + maxIndex + ", value: " + maxVal);
		}
	}
	
	
	
	

}
