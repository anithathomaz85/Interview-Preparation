package selfstudy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LearnStream {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Anna", "John", "Sam");
		names.stream().filter(name -> name.startsWith("A")).forEach(System.out::println);
		
		
		List<Integer> nums = Arrays.asList(2,4,6);
		List<Integer> squares = nums.stream()
			    					.map(n -> n * n)
			    					.collect(Collectors.toList());
		System.out.println(squares);
		
		nums.stream()
				.map(n -> n * n)
				.forEach(n->System.out.print(n+" "));

		
	}

}
