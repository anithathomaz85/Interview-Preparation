package gts;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * .Java program to find duplicate count and print unique element from string
 * (its contains more than millions character 
 * (Without using for loop and custom API)?
 * */
public class Q050_Q49_StringCharacterFrequency {
	public static void main(String[] args) {

		String inputStr = "this is a large string";
		characterFrequncyUsingStreams(inputStr);
		System.out.println();
		characterFrequncyUsingDS(inputStr);
	}

	private static void characterFrequncyUsingStreams(String inputStr) {

		Map<Character, Long> frequencyMap = inputStr.chars().mapToObj(c -> (char) c) 
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(frequencyMap);

		System.out.println("Duplicate characters:");
		frequencyMap.entrySet().stream()
				.filter(entry -> entry.getValue() > 1 && !Character.isWhitespace(entry.getKey()))
				.forEach(entry -> System.out.println("Character: " + entry.getKey() + ", Count: " + entry.getValue()));

		System.out.println("\nUnique characters:");
		frequencyMap.entrySet().stream()
				.filter(entry -> entry.getValue() == 1 && !Character.isWhitespace(entry.getKey()))
				.forEach(entry -> System.out.println("Character: " + entry.getKey() + ", Count: " + entry.getValue()));

	}

	private static void characterFrequncyUsingDS(String inputStr) {
		Map<Character, Integer> frequencyMap = new HashMap<>();
		for (char ch : inputStr.toCharArray()) {
			if (!Character.isWhitespace(ch)) {
				frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
			}
		}

		System.out.println("Duplicate characters:");
		for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println("Character: " + entry.getKey() + ", Count: " + entry.getValue());
			}
		}

		System.out.println("\nUnique characters:");
		for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
			if (entry.getValue() == 1) {
				System.out.println("Character: " + entry.getKey() + ", Count: " + entry.getValue());
			}
		}

	}
}
