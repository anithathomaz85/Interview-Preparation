package gts;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * An class customer has variables id, name, age properties. 
 * Here id and name are combined to be unique. 
 * use streams to remove duplicates from the list of customer.
 * */
/**
 * Use streams to get the customer with age greater than 40 in descending order.
 */
public class Q051_Q52_DuplicateCustomer {
	public static void main(String[] args) {

		List<Customer> list = Arrays.asList(new Customer(1, "Alice", 30), new Customer(2, "Bob", 25),

				new Customer(1, "Alice", 35), new Customer(3, "Charlie", 28), new Customer(3, "Mia", 50),
				new Customer(3, "Tim", 42));

		Set<String> seen = new HashSet<>();

		List<Customer> uniqueList = list.stream().filter(c -> seen.add(c.getKey())).collect(Collectors.toList());

		uniqueList.forEach(System.out::println);

		List<Customer> result = list.stream().filter(c -> c.age > 40)
				.sorted(Comparator.comparingInt(Customer::getAge).reversed()).collect(Collectors.toList());
		System.out.println("------- customer with age > 40 in descending order----");
		result.forEach(System.out::println);
	}

}

class Customer {
	int id;
	String name;
	int age;

	public Customer(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public String getKey() {

		return id + "_" + name; 
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return id + " - " + name + " - " + age;
	}
}
