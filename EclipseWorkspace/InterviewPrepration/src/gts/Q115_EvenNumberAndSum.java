package gts;

import java.util.Arrays;

/*115. Write a program from the given array int a={9,3,1,7,8,2}
* to List out the even numbers first and then you can print the even numbers sum.
*/
public class Q115_EvenNumberAndSum {
	public static void main(String[] args) {
		int[] a = { 9, 3, 1, 7, 8, 2 };

		int evenNumbersSum = Arrays.stream(a).filter(e -> e % 2 == 0)
				.peek(n -> System.out.println("Even numbers are :" + n + "," + " ")).sum();
		System.out.println("Sum of even numbers : " + evenNumbersSum);

	}
}
