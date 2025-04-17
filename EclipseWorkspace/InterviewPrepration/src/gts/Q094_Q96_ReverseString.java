package gts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Code for highest occurring char in a string
 */
public class Q094_Q96_ReverseString {

	public static void main(String[] args) {
		String name = "Annanya";
		name = name.toLowerCase();

		char highestChar = getHighestOccurrenceChar(name);
		int count = getCharCount(name, highestChar);

		System.out.println("Classic way:");
		System.out.println("Character with highest occurrence: " + highestChar);
		System.out.println("Number of occurrences: " + count);
		System.out.println();
		
		highestOccuringAllChar(name);
		System.out.println();

		System.out.println("Using Map: Returns all characters");
		Map<Character, Integer> result = getAllHighestOccurrenceCharUsingMap(name);
		System.out.println("Character with highest occurrence:");
		for (Map.Entry<Character, Integer> entry : result.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
		System.out.println();

		System.out.println("Using Streams:");
		getHighestOccurrenceCharUsingStreams(name);
		System.out.println();

		System.out.println("Using Streams: Returns all characters");
		getAllHighestOccurrenceCharUsingStreams(name);

	}

	public static char getHighestOccurrenceChar(String input) {
		int[] freq = new int[256];//256 possible ASCII characters

		// Count frequency of each character
		for (int i = 0; i < input.length(); i++) {
			freq[input.charAt(i)]++;
		}

		// Find the character with the highest frequency
		int max = -1;
		char result = ' ';
		for (int i = 0; i < input.length(); i++) {
			if (freq[input.charAt(i)] > max) {
				max = freq[input.charAt(i)];
				result = input.charAt(i);
			}
		}
		return result;
	}
	
	private static void highestOccuringAllChar(String name) {

		List<String> resultList = new ArrayList<String>();
		Set<Character> addedSet = new HashSet<Character>();
		int[] freq = new int[256];

		name = name.toLowerCase();
		for (int i = 0; i < name.length(); i++) {
			freq[name.charAt(i)]++;
		}

		int max = 0;
		for (int i = 0; i < name.length(); i++) {
			if (freq[name.charAt(i)] > max) {
				max = freq[name.charAt(i)];
			}
		}

		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if (freq[name.charAt(i)] == max && !addedSet.contains(c)) {
				resultList.add(name.charAt(i) + " - " + freq[name.charAt(i)]);
				addedSet.add(c);
			}
		}
		System.out.println("Character with highest occurrence: Returns all characters");
		resultList.forEach(System.out::println);

	}


	public static int getCharCount(String input, char ch) {
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ch) {
				count++;
			}
		}
		return count;
	}

	private static Map<Character, Integer> getAllHighestOccurrenceCharUsingMap(String name) {
		Map<Character, Integer> charFreqMap = new HashMap<>();

		int maxFreq = 0;

		// Step 1: Build frequency map and find max frequency
		for (char c : name.toCharArray()) {
			int freq = charFreqMap.getOrDefault(c, 0) + 1;
			charFreqMap.put(c, freq);
			maxFreq = Math.max(maxFreq, freq);
		}

		// Step 2: Collect characters with max frequency
		Map<Character, Integer> result = new HashMap<>();
		for (Map.Entry<Character, Integer> entry : charFreqMap.entrySet()) {
			if (entry.getValue() == maxFreq) {
				result.put(entry.getKey(), entry.getValue());
			}
		}
		return result;
	}

	private static void getHighestOccurrenceCharUsingStreams(String name) {

		name.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(entry -> {
					System.out.println("Character with highest occurrence: " + entry.getKey());
					System.out.println("Number of occurrences: " + entry.getValue());
				});

	}

	private static void getAllHighestOccurrenceCharUsingStreams(String name) {

		Map<Character, Long> frequencyMap = name.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		long maxFreq = Collections.max(frequencyMap.values());

		System.out.println("Character(s) with highest occurrence:");
		frequencyMap.entrySet().stream().filter(entry -> entry.getValue() == maxFreq)
				.forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));

	}

}
