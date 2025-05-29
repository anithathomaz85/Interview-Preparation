package evaluation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MissingNos {
	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(0, 1, 2, 4, 5, 7, 10);
		
		 List<Integer> fullRange = IntStream.rangeClosed(0, 10)
				 							.boxed()
				 							.collect(Collectors.toList());
		 
		 fullRange.stream()
         		  .filter(num -> !input.contains(num))
                  .forEach(num -> System.out.print(num + " "));
		 
		 System.out.println();

		 
		 List<Integer> full = IntStream.rangeClosed(0, 10).boxed().collect(Collectors.toList());
		 
		 full.stream().filter(num->!input.contains(num)).forEach(num->System.out.print(num+" "));
	}
}
