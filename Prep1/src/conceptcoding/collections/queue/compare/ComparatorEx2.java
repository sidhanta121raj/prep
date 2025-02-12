package conceptcoding.collections.queue.compare;

import java.util.Arrays;

public class ComparatorEx2 {

	public static void main(String[] args) {
		Integer [] ar = {1, 8, 2, 5, 7};
		Arrays.sort(ar, (a, b)->b-a);
		
		for(int a : ar) {
			System.out.println(a);
		}
		

	}

}
