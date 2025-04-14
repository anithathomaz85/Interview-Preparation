package selfstudy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors; 

public class StudyStreams {
	public static void main(String[] args) {
		
		secondLargestEvenNo();
		groupingByDemo();
		
	}
	
	public static void secondLargestEvenNo() {
		 List<Integer> list = Arrays.asList(1, 5, 3, 8, 2, 10, 4, 6, 7, 9);

	        int secondLargestEvenNo = list.stream()
	        		.filter(n->n%2==0)
	        		.map(n->n*5)
	        		.sorted(Comparator.reverseOrder())
	        		.skip(1)
	        		.findFirst()
	        		.orElse(null);
	        System.out.println(secondLargestEvenNo);

	}

	public static void groupingByDemo() {
		List<String> test = Arrays.asList("a", "bb", "ccc", "dd");
		Map<Integer,List<String>> resultMap = test.stream()
					.collect(Collectors.groupingBy(String::length));
		resultMap.forEach((key, value) -> System.out.println(key + "=" + value));
	}
}
