package java8.practice.set1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//How do you extract duplicate elements from an array?
public class DuplicatesInArray {

	public static void main(String[] args) {
		List<Integer> listOfIntegers = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);
		
		 Set<Integer> uniqueElements = new HashSet<>();
		 
		listOfIntegers.stream().filter(i -> ! uniqueElements.add(i)).peek(System.out::println).collect(Collectors.toSet());
        
	}

}
