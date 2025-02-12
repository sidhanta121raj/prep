package concpetcoding.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTerminalOperationEx1 {

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(2, 1, 4, 7, 10);
		
		//forEach
		list1.stream().filter(n -> n>=3 ).forEach( n -> System.out.println(n));
		
		//toArray
		Object[] ar = list1.stream().filter(n -> n>1).toArray( );
		Integer [] ar1 = list1.stream().filter(n -> n>1).toArray( t -> new Integer[t]);
		
		
		//reduce
		Optional<Integer> reducedValue = list1.stream().reduce((m, n) -> m+n );
		System.out.println(reducedValue.get());
		
		
		//collect
		List<Integer> list2 = list1.stream().filter(n -> n<100).collect(Collectors.toList());
		System.out.println(list2);
		
		
		//min
		Optional<Integer> num = list1.stream().min((a, b) -> a-b);
		System.out.println(num.get());
		
		Optional<Integer> num1 = list1.stream().min((a, b) -> b-a);
		System.out.println(num1.get());
		
		//max
		Optional<Integer> num2 = list1.stream().max((a, b) -> a-b);
		System.out.println(num2.get());
		
		Optional<Integer> num3 = list1.stream().max((a, b) -> b-a);
		System.out.println(num3.get());
		
		
		//count
		long count = list1.stream().count();
		System.out.println(count);
		
		//anyMatch
		boolean isExist = list1.stream().anyMatch(a->a>100);
		System.out.println(isExist);
		
		//allMatch
		isExist = list1.stream().allMatch(a->a<100);
		System.out.println(isExist);
		
		//noneMatch
		isExist = list1.stream().noneMatch(a->a<100);
		System.out.println(isExist);
		
		
		//findFirst
		Optional<Integer> first = list1.stream().filter(a -> a<3).findFirst();
		System.out.println(first.get());
		
		//findAny
		Optional<Integer> any = list1.stream().filter(a -> a<10).findAny();
		System.out.println(any.get());
	}

}
