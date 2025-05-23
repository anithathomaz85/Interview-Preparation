package gts;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 2nd larger number find from arraylist, 
 * it time and space complexity, 
 * and way to increase efficiency
 * */
public class Q076_SecondLargestNumber {
	
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10,20,30,50,70,80);
		

		secondLargestElementUsingStreams(list);
		Integer result = secondLargestElementManualLoop(list);
		if(result != null) {
			System.out.println("Second Largest : " +result);
		}
		else {
			System.out.println("No second largest found");
		}
	}
	
	/**
	 * Time Complexity: O(n) — single pass over list.
	   Space Complexity: O(1) — only two variables.
	 * */
	public static Integer secondLargestElementManualLoop(List<Integer> nums) {
		
		if (nums == null || nums.size() < 2) return null;

	    Integer first = null;
	    Integer second = null;
	    for (Integer num : nums) {
	        if (first == null || num > first) {
	            second = first;
	            first = num;
	        } else if ((second == null || num > second) && !num.equals(first)) {
	            second = num;
	        }
	    }
	    return second;
	} 


	/**
	 * Time Complexity:
			.distinct() → O(n)				
			.sorted() → O(n log n)				
			Rest → O(1)
			Total: O(n log n)
	  Space Complexity:
			O(n) (as Stream operations might internally buffer).
	 * */
	private static void secondLargestElementUsingStreams(List<Integer> list) {
		int secondLargestNumber = list.stream()
									.distinct()
									.sorted(Comparator.reverseOrder())
									.skip(1)
									.findFirst()
									.orElse(null);
		System.out.println("Second Largest Number " +secondLargestNumber);
	}
}