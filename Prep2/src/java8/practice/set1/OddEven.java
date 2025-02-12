package java8.practice.set1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

//Separate odd Even
public class OddEven {
	
	public static void main(String[] args) {
		
		List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
		Map<Boolean, List<Integer>> oddEvenNumbersMap = listOfIntegers.stream().collect(Collectors.partitioningBy(i -> i%2 == 0));
		
		Set<Entry<Boolean, List<Integer>>> entrySet = oddEvenNumbersMap.entrySet();
		
		for(Entry<Boolean, List<Integer>> entry : entrySet) {
			System.out.println("---------------------");
			if(entry.getKey()) {
				System.out.println("Even numbers");
			}else {
				System.out.println("Odd numbers");
			}
			System.out.println("---------------------");
			
			List<Integer> list = entry.getValue();
			for(Integer i : list) {
				System.out.println(i);
			}
		}
		
	}

	
	
}
