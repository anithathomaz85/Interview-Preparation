package gts;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 
 * class Employee { private Integer id; private String name; public static void
 * main(String[] args) { Employee e1 = new Employee(1, ""prahlad); Employee e2 =
 * new Employee(3, ""prahlad); Employee e3 = new Employee(5, ""prahlad);
 * Employee e4 = new Employee(8, ""prahlad); Employee e5 = new Employee(4,
 * ""prahlad);
 * 
 * List<Employee> empList = new ArrayList<>(); empList.add(e1); empList.add(e2);
 * empList.stream().sorted(Comparator.comparingInt(Employee::id)).Collect(collectors.toList());
 * 
 * empList.stream().sorted(Comparator.comparingInt(Employee::id)).distinct().Collect(collectors.toList());
 * 
 * } } Questions asked on this coding like: 1. how to sort the employee based on
 * id 2. eliminate the duplicates 3. how distinct() works internally
 * 
 */
public class Q064_Employee {

	public static void main(String[] args) {
		Employee e1 = new Employee(1, "prahlad");
		Employee e2 = new Employee(3, "prahlad");
		Employee e3 = new Employee(5, "prahlad");
		Employee e4 = new Employee(8, "prahlad");
		Employee e5 = new Employee(4, "prahlad");

		List<Employee> empList = Arrays.asList(e1, e2, e3, e4, e5);

		// 1. how to sort the employee based on id
		List<Employee> sortedEmpList = empList.stream().sorted(Comparator.comparing(Employee::getId))
				.collect(Collectors.toList());
		System.err.println("Employee List sorted with id");
		sortedEmpList.forEach(System.out::println);

		// 2. eliminate the duplicates
		System.err.println("Employee Distinct List");
		List<Employee> distinctList = empList.stream().distinct().collect(Collectors.toList());
		distinctList.forEach(System.out::println);

		// 3. how distinct() works internally
		/*
		 * The distinct() method in Java Stream API is used to remove duplicate elements
		 * from a stream. distinct() works by using a Set internally to track already
		 * seen elements. Specifically:
		 * 
		 * It relies on the hashCode() and equals() methods of the objects being
		 * processed.
		 * 
		 * It adds each element to a Set (like LinkedHashSet) as the stream is
		 * traversed.
		 * 
		 * If the element already exists in the set (based on equals() and hashCode()),
		 * it is skipped.
		 * 
		 */
	}
}

class Employee {
	private Integer id;
	private String name;

	public Employee(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}
	
		public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}
