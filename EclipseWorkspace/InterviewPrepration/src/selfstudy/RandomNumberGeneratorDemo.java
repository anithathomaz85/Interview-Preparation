package selfstudy;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class RandomNumberGeneratorDemo {

	public static void main(String[] args) {

		RandomGenerator rnd = RandomGeneratorFactory.of("L64X128MixRandom").create();
		System.out.println("Random int: " + rnd.nextInt());
		System.out.println("Random double: " + rnd.nextDouble());

		System.out.println("Stream of random numbers:");
		rnd.ints(5, 10, 100).forEach(System.out::println);

	}
}
