package concpetcoding.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamCreateEx1 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3000, 4100, 9000, 1000, 3500 );
		Stream<Integer> st1 = list.stream();
		
		
		Integer [] ar = {3000, 4100, 9000, 1000, 3500};
		Stream<Integer> st2 = Arrays.stream(ar);
		
		Stream<Integer> st3 = Stream.of(3000, 4100, 9000, 1000, 3500);
		
		
		Stream.Builder<Integer> streamBuilder = Stream.builder();
		streamBuilder.add(3000).add(4100).add(9000).add(1000).add(3500);
		Stream<Integer> st4 =  streamBuilder.build();
		
		
		Stream<Integer> st5 = Stream.iterate(1000, (n)->n+5000).limit(5);
		
		
		st1.forEach( n -> System.out.println(n));
		st2.forEach( n -> System.out.println(n));
		st3.forEach( n -> System.out.println(n));
		st4.forEach( n -> System.out.println(n));
		st5.forEach( n -> System.out.println(n));

	}

}
