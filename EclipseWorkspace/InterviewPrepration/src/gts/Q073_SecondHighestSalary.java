package gts;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Find 2nd higest salary employee in SQL and using java 8 
 * */

/**
 * SELECT salary FROM Employee ORDER BY salary DESC LIMIT 1 OFFSET 1;
 * */
public class Q073_SecondHighestSalary {
	
	public static void main(String[] args) {
		
		List<Employee1> employees = Arrays.asList(new Employee1(1, "A", 5000), 
												  new Employee1(2, "B", 7000),
												  new Employee1(3, "C", 6000), 
												  new Employee1(4, "D", 7000), 
												  new Employee1(5, "E", 4000));

		Double secondHighest = employees.stream()
										.map(Employee1::getSalary)
										.distinct()
										.sorted(Comparator.reverseOrder())
										.skip(1)
										.findFirst()
										.orElse(null);

		System.out.println("2nd Highest Salary: " + secondHighest);

	}
}

class Employee1 {
	private int id;
	private String name;
	private double salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	public Employee1(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

}