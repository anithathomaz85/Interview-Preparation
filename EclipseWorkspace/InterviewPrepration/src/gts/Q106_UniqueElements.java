package gts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
* 106. Question on printing only the unique elements from the array
*/
public class Q106_UniqueElements {
	//Without Stream
	public static List<Integer> getUniqueElements(int[] arr){
		Map<Integer, Integer>freqMap = new HashMap<>();
		for(int num : arr) {
			freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
		}
		List<Integer> result = new ArrayList<>();
		for(Map.Entry<Integer,Integer> entry :freqMap.entrySet()) {
			if(entry.getValue()==1) {
				result.add(entry.getKey());
			}
		}
		return result;
	}
	//With Stream
	public static List<Integer> getUniqueElementsWithStream(int[] arr){
		Map<Integer, Long> freqMap = Arrays.stream(arr)
				                              .boxed()
				                              .collect(Collectors.groupingBy(num->num, Collectors.counting()));
		return freqMap.entrySet().stream()
				      .filter(entry ->entry.getValue()==1)
				      .map(Map.Entry :: getKey)
				      .collect(Collectors.toList());
	}
 
	public static void main(String[] args) {
		int[] nums = {1, 2, 2, 3, 4, 4, 5};
		 System.out.println("Unique elements (Without Stream):");
		 getUniqueElements(nums).forEach(System.out::println);
		 System.err.println("\nUnique elements (With Stream):");
		 getUniqueElementsWithStream(nums).forEach(System.out::println);
	}
}
