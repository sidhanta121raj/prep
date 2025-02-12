package java8.practice.set1;

import java.util.stream.Collectors;
import java.util.stream.Stream;

//Find sum of all digits of a number in Java 8?
public class SumOfDigits {

	public static void main(String[] args) {
		int i = 15623;
		
		Integer sum = Stream.of((String.valueOf(i)).split("")).collect(Collectors.summingInt(a->Integer.parseInt(a)));
		System.out.println("Sum="+sum);

	}

}
