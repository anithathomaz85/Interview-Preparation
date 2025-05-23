package gts;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Find a character whose occurrence is the most
 * */
public class Q048_MostFrequentCharacter {
	public static void main(String[] args) {
		
		String inputStr = "this is a large string";
		
		 Optional<Map.Entry<Character, Long>> maxEntry =  inputStr.chars()
				.mapToObj(c->(char)c)
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet()
				.stream()
				.filter(entry->!Character.isWhitespace(entry.getKey()))
				.max(Map.Entry.comparingByValue());
				
		 if (maxEntry.isPresent()) {
	            Map.Entry<Character, Long> entry = maxEntry.get();
	            System.out.println("Most frequent character: '" + entry.getKey() + "' occurred " + entry.getValue() + " times.");
	        } else {
	            System.out.println("Most frequent character not found.");
	        }		
	}

}
