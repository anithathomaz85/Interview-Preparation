package gts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
* Question on giving the frequency of all numbers from array
*/
public class Q105_FrequencyCounter {

	// Method 1: Without Stream
	public static Map<Integer, Integer> getFreq(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : arr) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}
		return map;
	}

	// Method 2: With Stream
	public static Map<Integer, Long> getFreqWithStream(int[] arr) {
		return Arrays.stream(arr).boxed().collect(Collectors.groupingBy(num -> num, Collectors.counting()));
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 3, 1, 4, 2 };

		// Using method without stream
		System.out.println("Frequency (Without Stream):");
		Map<Integer, Integer> map1 = getFreq(nums);
		map1.forEach((key, value) -> System.out.println(key + " → " + value + " time(s)"));

		// Using method with stream
		System.out.println("\nFrequency (With Stream):");
		Map<Integer, Long> map2 = getFreqWithStream(nums);
		map2.forEach((key, value) -> System.out.println(key + " → " + value + " time(s)"));
	}
}