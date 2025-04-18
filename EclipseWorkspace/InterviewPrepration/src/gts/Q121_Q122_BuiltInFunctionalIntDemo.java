package gts;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
* Functional Interface theory and write a code for the functional interface and show its working
 
*/

interface MyFunctionalInterface {
	public void printMsg();
}

@FunctionalInterface
interface MyFunctionalInterface1 {
	public int add(int a, int b);
}

public class Q121_Q122_BuiltInFunctionalIntDemo {
	public static void main(String[] args) {
		/*
		 * 1. Consumer<T>
		 * 
		 * • Takes one input • Returns nothing • Used to perform an action on the input
		 * default method : accept
		 */
		Consumer<String> greet = name -> System.out.println("Hello, " + name + "!");
		greet.accept("John");

		/*
		 * 2. Predicate<T> • Takes one input • Returns a boolean • Used for conditions,
		 * filtering default method : test
		 */

		Predicate<Integer> isEven = num -> num % 2 == 0;
		System.out.println(isEven.test(10));
		System.out.println(isEven.test(7));

		List<String> list = List.of("apple", "banana", "avocado");
		list.stream().filter(word -> word.startsWith("a")).forEach(System.out::println);
		/*
		 * 3.Function Takes one input
		 * 
		 * Returns a result/output
		 * 
		 * Used to transform or map data
		 * 
		 * default method : apply
		 */
		Function<String, Integer> strLength = str -> str.length();
		System.out.println(strLength.apply("John"));

		/*
		 * 4.Supplier • Takes no input • Returns a value/output • Used to generate or
		 * supply values default method : get
		 */
		Supplier<String> message = () -> "Welcome, Soumya!";
		System.out.println(message.get());

	}

}
