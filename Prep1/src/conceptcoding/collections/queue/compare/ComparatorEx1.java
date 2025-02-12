package conceptcoding.collections.queue.compare;

import java.util.Arrays;

public class ComparatorEx1 {

	public static void main(String[] args) {
		Integer [] ar = {1, 8, 2, 5, 7};
		Arrays.sort(ar, (a, b)->a-b);
		
		for(int a : ar) {
			System.out.println(a);
		}
		

	}

}
