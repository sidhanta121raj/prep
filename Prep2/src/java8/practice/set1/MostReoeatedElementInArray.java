package java8.practice.set1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

//How do you find the most repeated element in an array
public class MostReoeatedElementInArray {

	public static void main(String[] args) {
		List<String> listOfStrings = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");
		Map<String, Long> map = listOfStrings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Entry<String, Long> entry = map.entrySet().stream().max(Map.Entry.comparingByValue()).get();

		System.out.println("Most Repeated element- "+entry.getKey()+" |Repititions- "+entry.getValue());
	}

}
