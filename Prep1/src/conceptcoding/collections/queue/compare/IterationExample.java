package conceptcoding.collections.queue.compare;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterationExample {
	
	public static void main(String[] args) {
		List<Integer> valList = new ArrayList<>();
		valList.add(1);
		valList.add(2);
		valList.add(3);
		valList.add(4);
		valList.add(5);
		
		System.out.println("Iterating the values through Iterator method:");
		Iterator<Integer> valItr = valList.iterator();
		
		while(valItr.hasNext()) {
			int val = valItr.next();
			System.out.println(val);
			if(val == 3) {
				valItr.remove();
			}
		}
		
		System.out.println("Iterating the values through Enhanced for loop:");
		
		for(int val : valList) {
			System.out.println(val);
		}
		
		System.out.println("Iterating the values through forEach method:");
		
		valList.forEach((val)->System.out.println(val));
		
		
	}

}
