package gts;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * Given a list of strings, 
 * find the maximum occurrence of the word 
 * and if 2 words have the same highest occurrence, 
 * sort it lexicographically  
 * and print the first element 
 * (Use streams for efficient coding)
 * */
public class Q123_MaxOccurrenceWord {
	public static void main(String[] args) {
		attempt1();
		attempt2();
		attempt3();
		attempt4();
		attempt5();
	}

	private static void attempt5() {
		List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "banana", "grape", "grape", "grape");
		String result = words.stream()
					.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
					.entrySet().stream()
					.sorted(Comparator.comparing(Map.Entry<String,Long>::getValue,Comparator.reverseOrder()).thenComparing(Map.Entry::getKey))
					.map(Map.Entry::getKey)
					.findFirst()
					.orElse("");
		System.out.println("Attempt 5: "+result);
							
		
	}

	private static void attempt4() {
		List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "banana", "grape", "grape", "grape");
		String result = words.stream()
							 .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
							 .entrySet().stream()
							 .sorted(Comparator.comparing(Map.Entry<String,Long>::getValue,Comparator.reverseOrder()).thenComparing(Map.Entry::getKey))
							 .map(Map.Entry::getKey)
							 .findFirst()
							 .orElse("Not found");
		System.out.println("Attempt 4: "+result);
		
	}

	private static void attempt3() {
		List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "banana", "grape", "grape", "grape");
		String result = words.stream()
							.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
							.entrySet().stream() 
							.sorted(Comparator.comparing(Map.Entry<String, Long>::getValue, Comparator.reverseOrder())
							        .thenComparing(Map.Entry::getKey))
							.map(Map.Entry::getKey)
							.findFirst()
							.orElse("");
		System.out.println("Attempt 3: "+result);
							
	}

	private static void attempt2() {
		
		List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "banana", "grape", "grape", "grape");
		String result = words.stream()
							.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
							.entrySet().stream()
							.sorted(Comparator.comparing(Map.Entry<String,Long>::getValue,Comparator.reverseOrder()).thenComparing(Map.Entry::getValue))
							.map(Map.Entry::getKey)
							.findFirst()
							.orElse("");
		System.out.println("Attempt 2: "+result);
							
	}

	private static void attempt1() {
		String result;
		List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "banana", "grape", "grape", "grape");
		result = words.stream()
							.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
							.entrySet().stream()
							.sorted((a, b) -> {
			                    int freqCompare = Long.compare(b.getValue(), a.getValue()); // -1,0,1
			                    return freqCompare != 0 ? freqCompare : a.getKey().compareTo(b.getKey()); 
			                })
							.map(Map.Entry::getKey)
							.findFirst()
							.orElse("");
		System.out.println("Attempt 1: "+result);
		 
		 /*
		  * If freqCompare != 0, we return it as is (sorting based on frequency).
			If freqCompare == 0 (same frequency), we compare the words lexicographically:
			a.getKey().compareTo(b.getKey()) sorts alphabetically in ascending order.
		  * */
		 
		 /*Output
		   Word frequency map after groupingBy:
		   {
			    "apple" = 2,
			    "banana" = 3,
			    "orange" = 1,
			    "grape" = 3
			}
			Sorting order:
				"banana" and "grape" both appear 3 times, so they are sorted alphabetically → "banana" comes before "grape".				
				"apple" appears 2 times.				
				"orange" appears 1 time.
			Final sorted list
				[ "banana", "grape", "apple", "orange" ]
			First element 
				banana
		 */
		 
		//OR
		
		result = words.stream()
								.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
								.entrySet().stream()
								.sorted(Comparator.comparing(Map.Entry<String, Long>::getValue, Comparator.reverseOrder())
								        .thenComparing(Map.Entry::getKey))
								.map(Map.Entry::getKey)
								.findFirst()
								.orElse("");
		System.out.println("Attempt 1.1: "+result);
	    /*
	     * .thenComparing(Map.Entry::getKey) - secondary comparator(If two words have the same frequency)
	        {
			    "apple" = 2,
			    "banana" = 3,
			    "orange" = 1,
			    "grape" = 3
			}
			[ "banana", "grape", "apple", "orange" ]
			banana
	     * */
		
	}

}

