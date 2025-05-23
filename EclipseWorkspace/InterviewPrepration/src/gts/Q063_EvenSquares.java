package gts;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  Given the array of Integers, 
 *  find the even numbers from the array 
 *  and print the square of the even numbers as list.
 * */
public class Q063_EvenSquares {

	public static void main(String[] args) {		 
		Integer[] numbers = { 1, 2, 3, 4, 5, 6 }; 
		List<Integer> evenSquares = Arrays.stream(numbers).filter(num -> num % 2 == 0) 
				.map(num -> num * num) 
				.collect(Collectors.toList());
 
		System.out.println("Squares of even numbers: " + evenSquares);
	}
}
