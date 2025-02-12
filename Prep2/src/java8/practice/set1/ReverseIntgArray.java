package java8.practice.set1;

import java.util.Arrays;
import java.util.stream.IntStream;

//Reverse an integer array
public class ReverseIntgArray {

	public static void main(String[] args) {
		int[] array = new int[] {5, 1, 7, 3, 9, 6};
	
		int[] array1  = IntStream.rangeClosed(1, array.length).map(i ->array[array.length-i]).toArray();
		System.out.println(Arrays.toString(array1));

	}

}
