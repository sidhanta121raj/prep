package conceptcoding.collections.queue.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsClassMethod {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(1);
		list.add(5);
		list.add(4);
		list.add(2);
		
		list.forEach((v)->System.out.print(v+" "));
		System.out.println();
		
		
		Collections.sort(list);
		list.forEach((v)->System.out.print(v+" "));
		System.out.println();
		
		System.out.println("Min:"+Collections.min(list));
		System.out.println("Max:"+Collections.max(list));

	}

}
