package java8.practice.set1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//1. Salary increment of 10% for employees whose age > 25 and age < 30 and salary < 25000
//2. Print the incremented salary right after the increment
public class EmployeeSalaryIncrement {

	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1, "emp1", 23, 18000));
		empList.add(new Employee(2, "emp2", 27, 24000));
		empList.add(new Employee(3, "emp3", 29, 21000));
		empList.add(new Employee(4, "emp4", 41, 15000));
		empList.add(new Employee(5, "emp5", 26, 32000));

		List<Employee> increasedSalariedEmpList = empList.stream()
		.filter(e -> e.getAge()>25 && e.getAge() <30 && e.getSalary() < 30000)
		.peek(System.out::println)
		//.map(e -> new Employee(e.getId(), e.getName(), e.getAge(), e.getSalary()*1.1))
		.peek(e -> e.setSalary(e.getSalary()*1.1))
		.peek(System.out::println)
		.collect(Collectors.toList());
		
		System.out.println(increasedSalariedEmpList);
	}

}

class Employee{
	private int id;
	private String name;
	private int age;
	private double salary;
	
	
	public Employee(int id, String name, int age, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	
	
}
