package java8.practice.set1;

import java.util.stream.IntStream;

//How do you find sum of first 10 natural numbers?
public class SumOfFirst10NaturalNo {

	public static void main(String[] args) {
		System.out.println(IntStream.range(1, 11).sum());

	}

}
