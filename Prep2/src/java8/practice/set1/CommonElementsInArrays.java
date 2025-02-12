package java8.practice.set1;

import java.util.Arrays;
import java.util.List;

//How do you find common elements between two arrays?
public class CommonElementsInArrays {

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);
        
        List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
        
        
        list1.stream().filter(a->list2.contains(a)).forEach(System.out::println);

	}

}
