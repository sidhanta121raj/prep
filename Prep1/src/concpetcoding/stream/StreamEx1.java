package concpetcoding.stream;

import java.util.ArrayList;
import java.util.List;

public class StreamEx1 {
	
	public static void main(String[] args) {
		List<Integer> salaryList = new ArrayList<>();
		salaryList.add(3000);
		salaryList.add(4100);
		salaryList.add(9000);
		salaryList.add(1000);
		salaryList.add(3500);
		
		//No of employees with salary more than 3000 by conventional way
		
		int count = 0;
		for(Integer salary : salaryList) {
			if(salary>3000) {
				count++;
			}
		}
		
		System.out.println("No of employees with salary more than 3000 are "+count);
		
		//No of employees with salary more than 3000 by stream
		
		//long countSalary = salaryList.stream().filter( sal -> sal > 3000 ).count();
		
		long countSalary = salaryList.stream().filter((sal)-> sal>3000).count();
				
		System.out.println("No of employees with salary more than 3000 are "+countSalary);
		
		
		
		
	}

}
