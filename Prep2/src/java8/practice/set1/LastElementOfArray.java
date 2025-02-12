package java8.practice.set1;

import java.util.Arrays;
import java.util.List;

// How do you get last element of an array?
public class LastElementOfArray {

	public static void main(String[] args) {
		List<String> listOfStrings = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");
		System.out.println(
		listOfStrings.stream().skip(listOfStrings.size()-1).findFirst().get());
        

	}

}
