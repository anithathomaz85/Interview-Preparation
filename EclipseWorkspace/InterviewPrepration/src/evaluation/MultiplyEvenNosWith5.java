package evaluation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultiplyEvenNosWith5 {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		list.stream().filter(n->n%2==0).map(n->n*5).forEach(System.out::println);
		
		String str ="Hello World";
		System.out.println(Arrays.stream(str.toLowerCase().split("")).collect(Collectors.groupingBy(c->c, Collectors.counting())));
		
		
	}

}