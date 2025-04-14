package gts;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given a list of String 
  -find the frequency of each word and print the result map using Stream
 * */
public class Q090_WordFrequency {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
		
		words.stream()
			 .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
			 .entrySet()
			 .stream()
			 .forEach(entry->System.out.println(entry.getKey()+" -> "+entry.getValue()));	
		}

}
