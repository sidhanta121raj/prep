package concpetcoding.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIntermediateOperationSeqEx1 {

	public static void main(String[] args) {
		List<Integer> numList = Arrays.asList(2, 1, 4, 7, 10);

		Stream<Integer> stream = numList.stream().
				filter(n -> n >= 3).
				peek(n -> System.out.println("After Filter " + n)).
				map(n -> -1 * n).peek(n -> System.out.println("After map " + n)).
				sorted().
				peek(n -> System.out.println("After sorting " + n));
		
		stream.collect(Collectors.toList());

	}

}
