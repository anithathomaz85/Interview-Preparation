package gts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q101_EmployeeSort {
	 
	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1, "John"));
		empList.add(new Employee(2, "Alby"));
		empList.add(new Employee(3, "Sara"));
 
		sortEmpList(empList);
	}
 
	public static void sortEmpList(List<Employee> empList) {
		/*
		 * empList.sort(Comparator.comparing(Employee::getEmpName).reversed()); //
		 * empList.sort(Comparator.comparing(Employee::getEmpId).reversed());
		 * System.out.println(empList);
		 */
 
		List<Employee> sortedEmployees = empList.stream()
 
				.sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
 
		/* below code is for reversing the emp name in reverse order */
 
		// List<Employee> sortedEmployees =
		// empList.stream().sorted(Comparator.comparing(Employee::getEmpName).reversed())
		// .collect(Collectors.toList());
 
		System.out.println(sortedEmployees);
 
	}
}