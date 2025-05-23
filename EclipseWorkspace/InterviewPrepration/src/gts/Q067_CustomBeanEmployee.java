package gts;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/***
 * Custom Bean - Employee ( Id, Name, Age, Gender) 1) Find Unique list - equals
 * and hashcode , streams with distinct()
 * 
 * 2) Find List of employees age between 25 and 35 (Use filter ) *
 */
public class Q067_CustomBeanEmployee {

	public static void main(String[] args) {
		
		List<NewEmployee> empList = Arrays.asList(new NewEmployee(1, "Alice", 28, "Female"),
				new NewEmployee(2, "Bob", 32, "Male"), new NewEmployee(3, "Charlie", 24, "Male"),
				new NewEmployee(4, "Diana", 35, "Female"), new NewEmployee(2, "Bob", 32, "Male"), // duplicate
				new NewEmployee(5, "Eve", 41, "Female"));
 
		// 1) Find Unique list - equals and hashcode , streams with distinct() 
		List<NewEmployee> uniqueList = empList.stream()
											  .distinct()
											  .collect(Collectors.toList());
		System.out.println("Unique Employee List:");
		uniqueList.forEach(System.out::println);
	
	
	//2) Find List of employees age between 25 and 35 (Use filter )	
		System.err.println("List of employees age between 25 and 35");
	List<NewEmployee> eList = empList.stream()
			                  .filter(e -> e.getAge() >= 25 && e.getAge() <= 35)
			                  .collect(Collectors.toList());
	
	eList.forEach(System.out::println);
	
	}

}

class NewEmployee {
	private int id;
	private String name;
	private int age;
	private String gender;

	public NewEmployee(int id, String name, int age, String gender) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender() {
		this.gender = gender;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof NewEmployee))
			return false;
		NewEmployee other = (NewEmployee) obj;
		return id == other.id && Objects.equals(name, other.name) && age == other.age
				&& Objects.equals(gender, other.gender);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, age, gender);
	}

	@Override
	public String toString() {
		return "Employee{id=" + id + ", name='" + name + '\'' + ", age=" + age + ", gender='" + gender + '\'' + '}';
	}
}
