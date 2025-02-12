package java8.practice.set1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromList {

	public static void main(String[] args) {
		List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
		List<String> distinctList = listOfStrings.stream().distinct().collect(Collectors.toList());
		
		distinctList.stream().forEach(System.out::println);

	}

}
