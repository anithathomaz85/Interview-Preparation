package gts;

/**
 * write the logic to make the class is immutable
 */
public class Q066_Immutable {
	public static void main(String[] args) {

		Person person1 = new Person("Person1", 30);

		System.out.println("Original Person: " + person1);

		// person1.name = "Anitha";
		// person1.age = 35;

		System.out.println("After trying to modify: " + person1);
	}

}

final class Person {
	private final String name;
	private final int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String toString() {
		return "Person{name: " + name + ", age: " + age;
	}
}

/**
 * 	Why This Class Is Immutable	 
		final class: can’t be extended.	 
		Fields are private and final: can't be modified once initialized.
		No setters.	 
		All values assigned via constructor.	 
		Only read-only access via getters.	
 * */
