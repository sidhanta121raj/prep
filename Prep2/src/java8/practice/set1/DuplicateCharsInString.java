package java8.practice.set1;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

//Print duplicate characters in a string
public class DuplicateCharsInString {

	public static void main(String[] args) {
		String inputString = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();
		System.out.println(inputString);
		

		 Set<Character> uniqueElements = new HashSet<>();
		inputString.chars().mapToObj(c-> (char) c).filter(c-> !uniqueElements.add(c)).peek(System.out::println).collect(Collectors.toSet());

	}

}
