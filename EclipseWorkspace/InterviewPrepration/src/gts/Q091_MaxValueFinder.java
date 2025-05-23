package gts;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/*
* Given  a list of integer find the max value.
*/
public class Q091_MaxValueFinder {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 25, 33, 99, 4, 76);

		// using streams
		int max = numbers.stream()
						.max(Integer::compareTo)
						.orElseThrow(() -> new NoSuchElementException("List is empty"));
		System.out.println("Maximum value using streams: " + max);

		// without streams
		int maxValue = Integer.MIN_VALUE;
		for (int num : numbers) {
			if (num > maxValue) {
				maxValue = num;
			}
		}
		System.out.println("Maximum value: " + maxValue);
	}
}