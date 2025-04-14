package gts;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * Given an integer array, 
 * Find the first repeating element in an array of integers. 
   Input: arr[] = {10, 5, 4, 9,6, 120, 4, 6, 10} . 
   Output --> 4
 * */
public class Q124_FirstRepeatingElement {


	public static void main(String[] args) {
		attempt1();
		
	}

	private static void attempt1() {
		List<Integer> nums= Arrays.asList(10, 5, 4, 9,6, 120, 4, 6, 10);
		int repeatingNum = nums.stream()
								.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
								.entrySet().stream()
								.filter(entry->entry.getValue()>1)
								.map(Map.Entry::getKey)
								.findFirst().orElse(0);								
		System.out.println("Attempt1: "+repeatingNum);		
		
		//or
		
		int[] arr = {10, 5, 4, 9, 6, 120, 4, 6, 10};

        Set<Integer> seen = new HashSet<>();
        int result = IntStream.of(arr) //converts the array into an IntStream,
                .filter(num -> !seen.add(num)) 
                .findFirst()
                .orElse(-1); // Return -1 if no repeating element is found

        System.out.println(result);
		
		
	}
}