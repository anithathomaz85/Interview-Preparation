package gts;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Demonstrate how to search for specific values in a list 
 * and calculate the time complexity of the implemented solution.
 * */
public class Q079_SearchList {

	private static boolean searchValue(List<Integer> list, int target) {
		for (int num : list) {
			if (num == target) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean searchValueUsingSet(List<Integer> numbers, int target) {
		Set<Integer> numberSet = new HashSet<>(numbers);
		if (numberSet.contains(target)) {
		    System.out.println(target + " found.");
		} else {
		    System.out.println(target + " not found.");
		}
		return false;
	}

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 25, 30, 45, 50, 60, 75);
		int target = 45;

		//Linear Search
		/**
		 * Time Complexity: O(n) → checking each element of the list one-by-one.
		   		Best case: O(1) → if the element is at the start.	
		   		Worst case: O(n) → if the element is at the end or not present		 
		  * */
		if (searchValue(numbers, target)) {
			System.out.println(target + " found in the list.");
		} else {
			System.out.println(target + " not found in the list.");
		}
		
		//Using HashSet for Faster Search
		/**
		 * Time Complexity: O(1) → contains() in HashSet is O(1)		   			 
		 * */
		if (searchValueUsingSet(numbers, target)) {
			System.out.println(target + " found in the list.");
		} else {
			System.out.println(target + " not found in the list.");
		}
	}
}
