package java8.practice.set1;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//Find first repeated character in a string
public class FirstRepeatedCharacter {

	public static void main(String[] args) {
		String inputString = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();
        Map<String, Long> map = Arrays.stream(inputString.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println(map);

        String firstRepeatedChar = map.entrySet().stream().filter(entry -> entry.getValue()>1).map(entry -> entry.getKey()).findFirst().get();
        System.out.println(firstRepeatedChar);
	}

}
