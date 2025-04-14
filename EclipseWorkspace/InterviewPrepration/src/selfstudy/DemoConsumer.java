package selfstudy;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class DemoConsumer {

	public static void main(String[] args) {

		List<Integer> values = Arrays.asList(4, 5, 6, 7, 8);

		/*
		 * // 1st method Consumer<Integer> c = new ConsumerImple(); values.forEach(c);
		 */

		/*
		 * // 2nd method Consumer<Integer> c = new Consumer<Integer>() { public void
		 * accept(Integer i) { System.out.println(i); } }; values.forEach(c);
		 */

		/*
		 * // 3rd method Consumer<Integer> c = i -> System.out.println(i);
		 * values.forEach(c);
		 */

		/*
		 * // 4th method values.forEach(i -> System.out.println(i));
		 */

		// 5th method
		values.stream().forEach(System.out::println);

	}
}

class ConsumerImple implements Consumer<Integer> {
	@Override
	public void accept(Integer i) {
		System.out.println(i);
	}
}
