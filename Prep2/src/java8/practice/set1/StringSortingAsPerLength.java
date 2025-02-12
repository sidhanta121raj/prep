package java8.practice.set1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Given a list of strings, sort them according to increasing order of their length?
public class StringSortingAsPerLength {

	public static void main(String[] args) {
		List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
		listOfStrings.stream().sorted(Comparator.comparing(s->s.length())).forEach(System.out::println);

	}

}
