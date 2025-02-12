package java8.practice.set1;

import java.util.Arrays;
import java.util.List;

//Given a list of strings, find out those strings which start with a number?
public class StringStartsWithNumber {

	public static void main(String[] args) {
		List<String> listOfStrings = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
		listOfStrings.stream().filter(s->Character.isDigit(s.charAt(0))).forEach(System.out::println);

	}

}
