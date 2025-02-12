package java8.practice.set1;

import java.util.Arrays;
import java.util.stream.Collectors;

//Reverse each word of a string using Java 8 streams?
public class ReverseEachWordOfString {

	public static void main(String[] args) {
		String str = "Java Concept Of The Day";
		String revStr = Arrays.stream(str.split(" "))
		.map(s->new StringBuffer(s).reverse())
		.collect(Collectors.joining(" "));
		
		System.out.println(revStr);

	}

}
