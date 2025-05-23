package gts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class Q023_IntervalsMerge {
 

	public static void main(String[] args) {
		int[][] input = {{1,3},{2,6},{8,10},{15,18}};
		 int[][] result = merge(input);
		 for(int[] interval : result) {
			 System.out.println(Arrays.toString(interval));
		 }
	}
	
	public static int[][] merge(int[][] intervals){
		if(intervals.length==0)return intervals;
		Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
		List<int[]> merge = new ArrayList<>();
		int[] current= intervals[0];
		merge.add(current);
		for(int[] next : intervals) {
			if(next[0] <= current[1]) {
				current[1] = Math.max(current[1], next[1]);
			}else {
				current = next;
				merge.add(current);
			}
		}
		return merge.toArray(new int[merge.size()][]);
	}
}