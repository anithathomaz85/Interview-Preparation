package selfstudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateFinder {
	public static void main(String[] args) {

		method1();
		method2();
		method3();
	}

	private static void method1() {
		System.out.println("METHOD 1");
		List<Integer> numbers = Arrays.asList(10, 20, 40, 10, 30, 60, 40);
		List<Integer> duplicates = numbers.stream().collect(Collectors.groupingBy(num -> num, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey)
				.collect(Collectors.toList());
		System.out.println("Duplicate values: " + duplicates);
	}

	private static void method2() {
		System.out.println("METHOD 2");
		List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 40, 10, 30, 60, 40));
		List<Integer> resultList = (List<Integer>) numbers.stream().sorted().distinct().collect(Collectors.toList());
		numbers.removeAll(resultList);
		System.out.println("Duplicate values: " + numbers);
	}

	private static void method3() {
		System.out.println("METHOD 3");
		List<Integer> numberList = Arrays.asList(10, 20, 40, 10, 30, 60, 40);
		List<Integer> duplicates = numberList.stream().filter(n -> Collections.frequency(numberList, n) > 1).distinct()
				.collect(Collectors.toList());

		System.out.println("Duplicate values: " + duplicates);
	}
}
//Collectors.groupingBy(classifierFunction, downstreamCollector)
//classifierFunction: Determines how elements in the stream are grouped
//num -> num
//Each number (num) is grouped by itself. So the key will be the number itself.

