package concpetcoding.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamIntermediateOperationEx1 {

	public static void main(String[] args) {
		Stream<String> st1 = Stream.of("HELLO", "EVERYBODY", "HOW", "ARE", "YOU", "DOING");
		List<String> list1 = st1.filter(a-> a.length()<=3).collect(Collectors.toList());
		System.out.println(list1);
		
		
		Stream<String> st2 = Stream.of("HELLO", "EVERYBODY", "HOW", "ARE", "YOU", "DOING");
		List<String> list2 = st2.map(a-> a.toLowerCase()).collect(Collectors.toList());
		System.out.println(list2);
		
		
		List<List<String>> sentences = Arrays.asList(
				Arrays.asList("I","LOVE","JAVA"),
				Arrays.asList("CONCEPTS", "ARE", "CLEAR"),
				Arrays.asList("IT'S", "VERY", "EASY"));
		
		List<String> list3 = sentences.stream().flatMap(( s ) -> s.stream()).collect(Collectors.toList());
		System.out.println(list3);
		
		
		List<String> list4 = sentences.stream().flatMap(( s ) -> s.stream()).map(s -> s.toLowerCase())
				.collect(Collectors.toList());
		System.out.println(list4);
		
		
		Integer[] ar = {1, 5, 2, 7, 9, 0, 4, 4, 2};
		List<Integer> list5 = Arrays.stream(ar).distinct().collect(Collectors.toList());
		System.out.println(list5);
		
		Integer[] ar1 = {1, 5, 2, 7, 9, 0, 4, 4, 2};
		List<Integer> list6 = Arrays.stream(ar).sorted().collect(Collectors.toList());
		System.out.println(list6);
		
		
		List<Integer> list7 = Arrays.stream(ar1).sorted((i, j) -> j-i).collect(Collectors.toList());
		System.out.println(list7);
		
		
		List<Integer> numbers = Arrays.asList(2, 1, 3, 4, 6);
		Stream<Integer> numberStream = numbers.stream().filter(n -> n>2)
				.peek(n -> System.out.println(n))
				.map( n -> -1* n);
		List<Integer> list8 = numberStream.collect(Collectors.toList());
		System.out.println(list8);
		
		Stream<Integer> numberStream1 = numbers.stream().limit(3);
		List<Integer> list9 = numberStream1.collect(Collectors.toList());
		System.out.println(list9);
		
		Stream<Integer> numberStream2 = numbers.stream().skip(3);
		List<Integer> list10 = numberStream2.collect(Collectors.toList());
		System.out.println(list10);
		
		
		List<String> stringNums = Arrays.asList("2", "1", "4", "7");
		IntStream intStream = stringNums.stream().mapToInt(n -> Integer.parseInt(n));
		int[] intAr = intStream.toArray();
		for(int x : intAr) {
			System.out.println(Arrays.asList(x));
		}
		
		
		int[] intAr1 = {2,1, 4, 7};
		IntStream intStream1 = Arrays.stream(intAr1);
		int[] intFilteredArray =intStream1.filter(n -> n>2).toArray();
		for(int x : intFilteredArray) {
			System.out.println(Arrays.asList(x));
		}
	}

}
