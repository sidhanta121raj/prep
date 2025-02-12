package concpetcoding.stream;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamEx1 {
	
	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(11, 22, 33, 44, 55, 66, 77, 88, 99, 110);
		
		long startTime1 = System.currentTimeMillis();
		
		list1.stream().map(i -> i*i).forEach(i -> System.out.println(i));
		System.out.println("Time taken by seq stream: "+ (System.currentTimeMillis()-startTime1) + " ms");
		
		long startTime2 = System.currentTimeMillis();
		list1.parallelStream().map(i -> i*i).forEach(i -> System.out.println(i));
		System.out.println("Time taken by seq stream: "+ (System.currentTimeMillis()-startTime2) + " ms");
	}
	

}
