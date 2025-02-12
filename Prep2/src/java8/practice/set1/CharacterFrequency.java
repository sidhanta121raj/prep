package java8.practice.set1;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharacterFrequency {

	public static void main(String[] args) {
		String inputString = "Java Concept Of The Day";
		Map<Character, Long> charCountMap = inputString
				.chars()
				.mapToObj(c-> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println(charCountMap);
		
		Map<String, Long> charCountMap1 = Stream.of(inputString.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println(charCountMap1);
		
		Map<String, Long> charCountMap2 = Arrays.stream(inputString.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println(charCountMap2);

	}

}
