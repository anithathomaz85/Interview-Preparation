package geeksforgeeks;

import java.util.Arrays;

/**
 * 
 * You are given the arrival times arr[] and departure times dep[] of all trains
 * that arrive at a railway station on the same day. Your task is to determine
 * the minimum number of platforms required at the station to ensure that no
 * train is kept waiting. At any given time, the same platform cannot be used
 * for both the arrival of one train and the departure of another. Therefore,
 * when two trains arrive at the same time, or when one arrives before another
 * departs, additional platforms are required to accommodate both trains.
 * Examples: 
 * Input: arr[] = [900, 940, 950, 1100, 1500, 1800], 
 * dep[] = [910, 1200, 1120, 1130, 1900, 2000] 
 * Output: 3 
 * Explanation: There are three trains during the time 9:40 to 12:00. 
 * So we need a minimum of 3 platforms.
 */
public class Q9_MinimumPlatforms {

	public static void main(String[] args) {
		int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
		int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };

		System.out.println("Minimum number of platforms required: " + findMinimumPlatforms(arr, dep));
	}

	public static int findMinimumPlatforms(int[] arr, int[] dep) {
        
        int n=arr.length;
        
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int platformsNeeded = 1;
        int maxPlatforms = 1;
        
        int i=1;
        int j=0;
        
        while(i<n && j<n){
            if(arr[i]<=dep[j]){ //Keep looping until either all trains have arrived (i < n) or all trains have departed (j < n)
                platformsNeeded++;
                i++;
            }else{
                platformsNeeded--;
                j++;
            }
            maxPlatforms=Math.max(maxPlatforms,platformsNeeded);
        }
        return maxPlatforms;
    }
}
