package selfstudy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DuplicatesChecker {

	public static void main(String[] args) {

		usingStream();
		// normalWay();
		System.out.println("_________________________________");
		wordFrequency();
		System.out.println("_________________________________");
		karpagam();
		System.out.println("_________________________________");
		piyush();

	}

	private static void usingStream() {

		List<Integer> numsList = Arrays.asList(10, 20, 40, 10, 30, 60, 40);

		Predicate<Integer> duplicatePredicate = new Predicate<Integer>() {
			@Override
			public boolean test(Integer n) {
				return Collections.frequency(numsList, n) > 1;
			}
		};

		List<Integer> duplicates = numsList.stream().filter(n -> Collections.frequency(numsList, n) > 1).distinct()
				.collect(Collectors.toList());
		System.out.println(duplicates);

	}

	private static void wordFrequency() {
		String text = "Hi, I am learning java and streams is a new feature introduced in java and streams is interesting";

		List<String> words = Arrays.asList(text.toLowerCase().split(" "));

		List<String> duplicateWords = words.stream().filter(w -> Collections.frequency(words, w) > 1) // Check if a word
																										// appears more
																										// than once
				.distinct() // Remove duplicates from the result
				.collect(Collectors.toList());

		// Print duplicate words
		System.out.println("Duplicate words: " + duplicateWords);

		Map<String, Long> wordCount = Arrays.stream(text.toLowerCase().split(" "))
				.collect(Collectors.groupingBy(word -> word, Collectors.counting()));
		System.out.println("word count=" + wordCount);

		List<String> words1 = Arrays.stream(text.toLowerCase().split(text))
				.collect(Collectors.groupingBy(word -> word, Collectors.counting())).entrySet().stream()
				.filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());

		System.out.println(words1);
	}

	private static void karpagam() {

		// find the longest word in a list using Streams.
		List<String> fruits = Arrays.asList("apple", "banana", "papaya", "grapes");
		Optional<String> longest = fruits.stream().max(Comparator.comparingInt(String::length));
		System.out.println(longest);

		int maxLength = fruits.stream().mapToInt(String::length).max().orElse(0);
		System.out.println("max len=" + maxLength);
		List<String> maxFruitsLen = fruits.stream().filter(fruit -> fruit.length() == maxLength)
				.collect(Collectors.toList());
		System.out.println(maxFruitsLen);

		// Eliminate duplicates
		List<Integer> numbers = List.of(1, 2, 3, 4, 6, 6, 3, 9, 10);
		System.out.println(numbers.stream().collect(Collectors.toSet()));
		System.out.println(numbers.stream().distinct().collect(Collectors.toList()));

	}

	private static void piyush() {
		List<Integer> list = List.of(10, 34, 2, -9, 45, 8, 30, -30);
		List<String> strList = List.of("abc", "def", "ghi");

		// Filter even numbers from a list of integers
		list.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));

		System.out.println("\n");

		// Convert a list of strings to uppercase
		strList.stream().map(String::toUpperCase).forEach(s -> System.out.print(s + " "));

		// Find the sum of all integers greater than 5
		int sum = list.stream().filter(n -> n > 5).reduce(0, (a, b) -> a + b);
		System.out.println("SUM=" + sum);

		// Find the longest word in a list of strings
		strList.stream().max(Comparator.comparingInt(String::length)).get();

		int maxL = strList.stream().mapToInt(String::length).max().orElse(0);
		List<String> strs = strList.stream().filter(s -> s.length() == maxL).collect(Collectors.toList());
		System.out.println(strs);

		list.stream().forEach(n -> System.out.print(n + ","));

		List<String> list1 = Arrays.asList("hello", "stream", "API", "shortest");
		Map<Character, List<String>> groupedByFirstLetter = list1.stream()
				.collect(Collectors.groupingBy(s -> s.charAt(0)));
		System.out.println(groupedByFirstLetter);

	}

}
