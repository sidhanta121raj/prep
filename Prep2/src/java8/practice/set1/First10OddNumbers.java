package java8.practice.set1;

import java.util.stream.IntStream;
import java.util.stream.Stream;

//First 10 odd numbers
public class First10OddNumbers {

	public static void main(String[] args) {
		Stream.iterate(new int[] {1, 3}, f -> new int[] {f[1], f[1]+2})
        .limit(10)
        .map(f -> f[0])
        .forEach(i -> System.out.print(i+" "));
		
		System.out.println("");
		System.out.println("----------------------");
		IntStream.rangeClosed(1, 10).map(i -> (i*2)-1).forEach(i -> System.out.print(i+" "));

	}

}
