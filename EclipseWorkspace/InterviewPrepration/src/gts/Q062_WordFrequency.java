package gts;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given a list of strings, count the frequency of each word using Streams 
 * and return a Map with words as keys and their frequencies as values.
 * */
public class Q062_WordFrequency {

	public static Map<String, Long> countWordFrequency(List<String> words) {
		return words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}

	public static void main(String[] args) {
		List<String> wordList = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
		Map<String, Long> wordFrequency = countWordFrequency(wordList);
		System.out.println("Word Frequencies: " + wordFrequency);
	}
}