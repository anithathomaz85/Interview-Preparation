package gts;

import java.util.Arrays;
import java.util.List;

/***
 * Given a list of integer 
   pick out even number - 
   convert it into square - 
   print it on screen  using Stream API
 * 
 * */
public class Q089_EvenSquares {
	public static void main(String[] args) {
		 List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		 numbers.stream()
		 		.filter(n->n%2==0)
		 		.map(n->n*n)
		 		.forEach(System.out::println); 
		
	}
}
