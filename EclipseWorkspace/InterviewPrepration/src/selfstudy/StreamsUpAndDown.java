package selfstudy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsUpAndDown {
	public static void main(String[] args) {

		// Reverse a each word in a sentence
		String str1 = "Hello World Streams";
		Arrays.stream(str1.split(" ")).map((word) -> new StringBuilder(word).reverse()).forEach(System.out::println);

		System.out.println("-------------------------------------------------------");

		// Reverse a string using IntStream
		String str2 = "hello";

		String reversedStr = IntStream.range(0, str2.length()).mapToObj(i -> str2.charAt(str2.length() - 1 - i))
				.map(String::valueOf).collect(Collectors.joining());
		System.out.println("Reversed String way1: " + reversedStr);

		System.out.print("Reversed String way2: ");
		IntStream.range(0, str2.length()) // 0,1,2,3,4
				.mapToObj(i -> str2.charAt(str2.length() - 1 - i)).map(String::valueOf).forEach(System.out::print);

		StringBuilder reversedStr1 = new StringBuilder();
		for (int i = str2.length() - 1; i >= 0; i--) {
			reversedStr1.append(str2.charAt(i));
			}
		System.out.println("\nReversed String way3: " + reversedStr.toString());

		System.out.println("-------------------------------------------------------");

		// Output: {1=[a], 2=[bb, dd], 3=[ccc]}
		List<String> str3 = Arrays.asList("a", "bb", "ccc", "dd");

		Map<Integer, List<String>> result = str3.stream().collect(Collectors.groupingBy(str -> str.length()));
		System.out.println(result);

		System.out.println("-------------------------------------------------------");

		// Second largest odd no multiplied by 10
		List<Integer> list2 = List.of(2, 4, 3, 1, 6, 7, 10, 9, 5, 8);
		int sencondLargestOddMultipliedby10 = list2.stream().filter(n -> n % 2 != 0).map(n -> n * 10)
				.sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);
		System.out.println(sencondLargestOddMultipliedby10);

		// Find Duplicate
		List<Integer> numbers = Arrays.asList(10, 20, 40, 10, 30, 60, 40);
		List<Integer> duplicates1 = numbers.stream().collect(Collectors.groupingBy(num -> num, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey)
				.collect(Collectors.toList());
		System.out.println("Duplicate way1: " + duplicates1);

		List<Integer> duplicates2 = numbers.stream().filter(n -> Collections.frequency(numbers, n) > 1).distinct()
				.collect(Collectors.toList());

		System.out.println("Duplicate way2: " + duplicates2);

		System.out.println("-------------------------------------------------------");

		
		String text = "Hi, I am learning java and streams is a new feature introduced in java and streams is interesting";
		// Duplicate Words in a sentence
		List<String> words = Arrays.asList(text.toLowerCase().split(" "));

		List<String> duplicateWords = words.stream().filter(w -> Collections.frequency(words, w) > 1) 
				.distinct() 
				.collect(Collectors.toList());		
		System.out.println("Duplicate words way1: " + duplicateWords);
		
		List<String> words1 = Arrays.stream(text.toLowerCase().split("[\\s\\p{Punct}]+"))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
		System.out.println("Duplicate words way2: "+words1);

		//Count words
		Map<String, Long> wordCount = Arrays.stream(text.toLowerCase().split(" "))
				.collect(Collectors.groupingBy(word -> word, Collectors.counting()));
		System.out.println("Words Count=" + wordCount);

		System.out.println("-------------------------------------------------------");
		
		List<String> list1 = List.of("apple", "orange");
		 String result3 = list1.stream()
	                .flatMapToInt(String::chars)
	                .mapToObj(c -> (char) c)
	                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
	                .entrySet().stream()
	                .map(e -> e.getKey() + "-" + e.getValue())
	                .collect(Collectors.joining(", "));
	        System.out.println(""+result3);
		
	    System.out.println("-------------------------------------------------------");

		
		List<Transaction> transactions = Arrays.asList(new Transaction("2022-01-01", 100),
				new Transaction("2022-01-01", 200), new Transaction("2022-01-02", 300),
				new Transaction("2022-01-02", 400), new Transaction("2022-01-03", 500));

		Map<String, Integer> resultMap = transactions.stream()
				.collect(Collectors.groupingBy(Transaction::getDate, Collectors.summingInt(Transaction::getAmount)));
		System.out.println(resultMap);

	
		System.out.println("-------------------------------------------------------");
		

	}

}

class Transaction {
	private String date;
	private int amount;

	public Transaction(String date, int amount) {
		this.date = date;
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Transaction{date='" + date + "', amount=" + amount + "}";
	}
}
